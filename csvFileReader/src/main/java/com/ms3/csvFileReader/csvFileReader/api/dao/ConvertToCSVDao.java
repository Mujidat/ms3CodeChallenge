package com.ms3.csvFileReader.csvFileReader.api.dao;

import com.ms3.csvFileReader.csvFileReader.model.ModelFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvertToCSVDao extends CrudRepository <ModelFile, Long> {

}

