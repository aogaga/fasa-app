package com.aogaga.fasa.validation;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RuleResult{
    private  String ruleCode;
    private  boolean passed;
    private  String message;
    public  Severity severity;
}

