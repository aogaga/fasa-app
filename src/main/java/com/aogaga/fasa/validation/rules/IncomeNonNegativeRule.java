package com.aogaga.fasa.validation.rules;

import com.aogaga.fasa.models.Application;
import com.aogaga.fasa.validation.FasaBaseRule;
import com.aogaga.fasa.validation.RuleResult;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static com.aogaga.fasa.util.RuleResultHelpers.fail;
import static com.aogaga.fasa.util.RuleResultHelpers.pass;

@Component
public class IncomeNonNegativeRule implements FasaBaseRule {
    @Override
    public String code() {
        return "INC_002";
    }

    @Override
    public RuleResult apply(Application d) {
        BigDecimal studentIncome = d.getIncome().getStudentIncome();
        BigDecimal parentIncome = d.getIncome().getParentIncome();

        if ((studentIncome != null && studentIncome.compareTo(BigDecimal.ZERO) < 0) ||
                (parentIncome != null && parentIncome.compareTo(BigDecimal.ZERO) < 0)) {
            return fail(code(), "Income cannot be negative");
        }

        return pass(code());
    }
}
