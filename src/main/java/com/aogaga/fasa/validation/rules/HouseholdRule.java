package com.aogaga.fasa.validation.rules;

import com.aogaga.fasa.models.Application;
import com.aogaga.fasa.validation.FasaBaseRule;
import com.aogaga.fasa.validation.RuleResult;
import org.springframework.stereotype.Component;

import static com.aogaga.fasa.util.RuleResultHelpers.fail;
import static com.aogaga.fasa.util.RuleResultHelpers.pass;

@Component
public class HouseholdRule implements FasaBaseRule {
    @Override
    public String code() {
        return "HH_001";
    }

    @Override
    public RuleResult apply(Application d) {
        return d.getHousehold().getNumberInCollege() <= d.getHousehold().getHouseHoldCount()
                ? pass(code())
                : fail(code(), "Number in college cannot exceed household size");
    }
}
