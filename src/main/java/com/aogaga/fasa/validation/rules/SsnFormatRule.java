package com.aogaga.fasa.validation.rules;

import com.aogaga.fasa.models.Application;
import com.aogaga.fasa.validation.FasaBaseRule;
import com.aogaga.fasa.validation.RuleResult;
import org.springframework.stereotype.Component;

import static com.aogaga.fasa.util.RuleResultHelpers.fail;
import static com.aogaga.fasa.util.RuleResultHelpers.pass;

@Component
public class SsnFormatRule implements FasaBaseRule {
    @Override
    public String code() {
        return "SSN_001";
    }

    @Override
    public RuleResult apply(Application data) {
        return data.getStudentInfo().getSsn().matches("\\\\d{9}")
                ? pass(code())
                : fail(code(), "Invalid SSN format");
    }
}
