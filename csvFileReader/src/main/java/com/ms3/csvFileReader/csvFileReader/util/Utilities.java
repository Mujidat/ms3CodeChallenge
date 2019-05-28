package com.ms3.csvFileReader.csvFileReader.util;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.ms3.csvFileReader.csvFileReader.model.ModelFile;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class Utilities {
    public static List<ModelFile> loadObjectList(File file) {

        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper mapper = new CsvMapper();

            MappingIterator<ModelFile> readValues =
                    mapper.reader(ModelFile.class).with(bootstrapSchema).readValues(file);
            return readValues.readAll();
        } catch (Exception e) {
            //logger.error("Error occurred while loading object list from file " + fileName, e);
            return Collections.emptyList();
        }

    }
    public static boolean checkRowEmpty(ModelFile modelRow) {
        if (modelRow.getA().isEmpty() || modelRow.getB().isEmpty() || modelRow.getC().isEmpty() || modelRow.getD().isEmpty() || modelRow.getE().isEmpty()
                || modelRow.getF().isEmpty() || modelRow.getG().isEmpty() ||modelRow.getH().isEmpty() || modelRow.getI().isEmpty() || modelRow.getJ().isEmpty()) {
            return false;
        }
        return true;
    }
}
