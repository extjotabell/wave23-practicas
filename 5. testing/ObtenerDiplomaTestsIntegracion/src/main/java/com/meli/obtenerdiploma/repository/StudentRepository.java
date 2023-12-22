package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

@Repository
public class StudentRepository implements IStudentRepository {

    private String SCOPE;
    private static final Logger logger = LoggerFactory.getLogger(StudentRepository.class);

    public StudentRepository() {
        Properties properties =  new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            this.SCOPE = properties.getProperty("api.scope");
        } catch (IOException e) {
            logger.error("An error occurred while loading properties", e);
        }
    }

    @Override
    public Set<StudentDTO> findAll() {
        Set<StudentDTO> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/users.json");
            loadedData = objectMapper.readValue(file, new TypeReference<Set<StudentDTO>>(){});
        } catch (IOException e) {
            logger.error("Failed while initializing DB, check your resources files or JSON formatting.", e);
        }
        return loadedData;
    }
}