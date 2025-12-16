package com.aogaga.fasa.validation.rules;

import com.aogaga.fasa.models.Application;
import com.aogaga.fasa.models.MaritalStatus;
import com.aogaga.fasa.validation.FasaBaseRule;
import com.aogaga.fasa.validation.RuleResult;
import org.springframework.stereotype.Component;

import static com.aogaga.fasa.util.RuleResultHelpers.fail;
import static com.aogaga.fasa.util.RuleResultHelpers.pass;

@Component
public class SpouseRule implements FasaBaseRule {
    @Override
    public String code() {
        return "MAR_001";
    }

    @Override
    public RuleResult apply(Application d) {
        if (d.getMaritalStatus() == MaritalStatus.married && d.getSpouseInfo() == null)
            return fail(code(), "Spouse information required when married");
        return pass(code());
    }
}
