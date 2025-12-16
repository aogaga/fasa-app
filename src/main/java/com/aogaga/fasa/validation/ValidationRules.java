package com.aogaga.fasa.validation;

import com.aogaga.fasa.models.Application;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidationRules {
    private final List<FasaBaseRule> rules;



    public ValidationRules(List<FasaBaseRule> rules) {
        this.rules = rules;
    }

    public List<RuleResult> validate(Application application) {
        return rules.stream().map(r -> r.apply(application)).toList();
    }
}
