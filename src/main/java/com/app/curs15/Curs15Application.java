package com.app.curs15;

import com.app.curs15.extractData.ExtractPerson;
import com.app.curs15.extractData.ExtractPersons;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Curs15Application {

    public static void main(String[] args) {
        SpringApplication.run(Curs15Application.class, args);
//        ExtractPersons extractPersons = new ExtractPersons();
//        try {
//            extractPersons.extractPersons();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
