package com.aogaga.fasa.util;


import com.aogaga.fasa.validation.RuleResult;

import java.util.List;

public class ValidationResponse {

    private boolean valid;
    private List<RuleResult> results;

    public ValidationResponse() {
    }

    public ValidationResponse(boolean valid, List<RuleResult> results) {
        this.valid = valid;
        this.results = results;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public List<RuleResult> getResults() {
        return results;
    }

    public void setResults(List<RuleResult> results) {
        this.results = results;
    }
}