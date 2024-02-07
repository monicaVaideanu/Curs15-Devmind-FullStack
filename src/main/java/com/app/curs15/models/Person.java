package com.app.curs15.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String nume;
    private String prenume;
    private int varsta;
}
