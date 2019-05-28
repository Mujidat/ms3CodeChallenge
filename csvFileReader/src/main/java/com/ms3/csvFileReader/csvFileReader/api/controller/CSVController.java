package com.ms3.csvFileReader.csvFileReader.api.controller;

import com.ms3.csvFileReader.csvFileReader.model.Response;
import com.ms3.csvFileReader.csvFileReader.service.ConvertToCSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@Controller
public class CSVController {

    @Autowired
    ConvertToCSVService toCSV;

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Response createCSVRecord (@PathVariable String filepath) {
        return toCSV.setCSVFile(filepath);
    }
}
