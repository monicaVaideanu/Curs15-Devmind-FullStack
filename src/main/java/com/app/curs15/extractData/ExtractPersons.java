package com.app.curs15.extractData;

import com.app.curs15.models.Person;
import com.app.curs15.models.Persons;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ExtractPersons {
    ObjectMapper objectMapper = new ObjectMapper();

    public void extractPersons() throws IOException {
        File file = new File("src/main/resources/ListOfPeople.json");
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY,true);
        try {
            Persons persons = objectMapper.readValue(file, new TypeReference<Persons>(){});
            List<Person> personList = persons.getPersons();
            for (Person person : personList) {
                System.out.println(person);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
