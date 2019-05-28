package com.ms3.csvFileReader.csvFileReader.service;

import com.ms3.csvFileReader.csvFileReader.api.dao.ConvertToCSVDao;
import com.ms3.csvFileReader.csvFileReader.model.ModelFile;
import com.ms3.csvFileReader.csvFileReader.model.Response;
import com.ms3.csvFileReader.csvFileReader.util.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConvertToCSVService {
    @Autowired
    ConvertToCSVDao toCSVDao;
    Response response;
    public Response setCSVFile (String fileName) {
        List<ModelFile> list = new ArrayList<ModelFile>();
        try {
            File csvfile1 = new ClassPathResource(fileName).getFile();
            list = Utilities.loadObjectList(csvfile1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int j=0;//successful
        int k=0; //failed
        for (int i =0; i< list.size(); i++) {
            ModelFile item = list.get(i);
            if (Utilities.checkRowEmpty(item))  {
                toCSVDao.save(item);
                j++;
            }
            else {
                k++;
            }
        }
        response = new Response(list.size(), j,k);
        return response;
    }
}
