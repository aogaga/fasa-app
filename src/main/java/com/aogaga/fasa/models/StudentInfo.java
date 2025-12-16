package com.aogaga.fasa.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentInfo {
    private String firstName;
    private String lastName;
    private String ssn;
    private LocalDate dateOfBirth;

}
