package com.aogaga.fasa.validation.rules;

import com.aogaga.fasa.models.Application;
import com.aogaga.fasa.util.StateCodes;
import com.aogaga.fasa.validation.FasaBaseRule;
import com.aogaga.fasa.validation.RuleResult;
import org.springframework.stereotype.Component;

import static com.aogaga.fasa.util.RuleResultHelpers.fail;
import static com.aogaga.fasa.util.RuleResultHelpers.pass;

@Component
public class StateRule implements FasaBaseRule {
    @Override
    public String code() {
        return "STATE_001";
    }

    @Override
    public RuleResult apply(Application d) {
        return StateCodes.ALL.contains(d.getStateOfResidence())
                ? pass(code())
                : fail(code(), "Invalid US state code");
    }
}
