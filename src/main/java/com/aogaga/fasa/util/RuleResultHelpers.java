package com.aogaga.fasa.util;

import com.aogaga.fasa.validation.RuleResult;
import com.aogaga.fasa.validation.Severity;

public class RuleResultHelpers {

    public static RuleResult pass(String ruleCode) {
        return new RuleResult(ruleCode, true, "Passed", Severity.INFO);
    }

    public static RuleResult fail(String ruleCode, String message) {
        return new RuleResult(ruleCode, false, message, Severity.ERROR);
    }
}
