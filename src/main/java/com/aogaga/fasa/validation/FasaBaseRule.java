package com.aogaga.fasa.validation;

import com.aogaga.fasa.models.Application;

public interface FasaBaseRule {
    String code();
    RuleResult apply(Application application);
}