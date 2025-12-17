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
        if (d.getHousehold() == null) {
            return fail(code(), "Household information is missing");
        }
        Integer numberInCollege = d.getHousehold().getNumberInCollege();
        Integer householdCount = d.getHousehold().getNumberInHousehold();

        if (numberInCollege == null || householdCount == null) {
            return fail(code(), "Household numbers are incomplete");
        }

        return numberInCollege <= householdCount
                ? pass(code())
                : fail(code(), "Number in college cannot exceed household size");
    }
}
