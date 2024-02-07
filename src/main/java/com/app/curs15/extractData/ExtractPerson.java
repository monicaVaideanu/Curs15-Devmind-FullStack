package com.app.curs15.extractData;

import com.app.curs15.models.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ExtractPerson {
    ObjectMapper objectMapper = new ObjectMapper();

    public void extractPerson() throws IOException {
        File file = new File("src/main/resources/Person.json");
        try {
            Person person = objectMapper.readValue(file, Person.class);
            System.out.println(person);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
