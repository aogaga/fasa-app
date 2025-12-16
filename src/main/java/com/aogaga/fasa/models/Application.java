package com.aogaga.fasa.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Application {
    @JsonProperty("studentInfo")
    private StudentInfo studentInfo;
    private DependencyStatus dependencyStatus;
    private Household household;
    private MaritalStatus maritalStatus;
    private Income income;
    private String stateOfResidence;
    private SpouseInfo spouseInfo;

}
