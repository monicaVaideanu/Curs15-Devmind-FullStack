package com.app.curs15.models;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Persons {
    private List<Person> persons;

}
