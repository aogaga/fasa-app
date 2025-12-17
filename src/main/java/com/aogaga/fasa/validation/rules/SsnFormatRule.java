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
        String ssn = data.getStudentInfo().getSsn();
        if (ssn == null) {
            return fail(code(), "SSN is missing");
        }
        return ssn.matches("\\d{9}")  // match exactly 9 digits
                ? pass(code())
                : fail(code(), "Invalid SSN format");
    }
}
