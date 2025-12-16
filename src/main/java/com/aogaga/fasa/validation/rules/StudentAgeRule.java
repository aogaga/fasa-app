package com.aogaga.fasa.validation.rules;

import com.aogaga.fasa.models.Application;
import com.aogaga.fasa.validation.FasaBaseRule;
import com.aogaga.fasa.validation.RuleResult;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

import static com.aogaga.fasa.util.RuleResultHelpers.fail;
import static com.aogaga.fasa.util.RuleResultHelpers.pass;

@Component
public class StudentAgeRule implements FasaBaseRule {


    @Override
    public String code() {
        return "AGE_001";
    }

    @Override
    public RuleResult apply(Application d) {
        int age = Period.between(d.getStudentInfo().getDateOfBirth(), LocalDate.now()).getYears();
        return age >= 14
                ? pass(code())
                : fail(code(), "Student must be at least 14 years old");
    }
}
