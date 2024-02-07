package com.app.curs15.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class PersonTest {
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void pojoToJsonString() throws JsonProcessingException {
        Person person = new Person("Mark", "James", 20);
        String json = objectMapper.writeValueAsString(person);
        assert(json.equals("{\"nume\":\"Mark\",\"prenume\":\"James\",\"varsta\":20}"));
    }
    @Test
    void givenValidJson_whenExtractFromFile_thenCreatePerson() throws IOException {
        File file = new File("src/main/resources/Person.json");
        Person person = objectMapper.readValue(file, Person.class);
        assert(person.getNume().equals("Ion"));
        assert(person.getPrenume().equals("Popescu"));
        assert(person.getVarsta() == 20);
    }
}
