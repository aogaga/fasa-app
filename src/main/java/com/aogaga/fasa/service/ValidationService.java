package com.aogaga.fasa.service;

import com.aogaga.fasa.controller.AppController;
import com.aogaga.fasa.models.Application;
import com.aogaga.fasa.util.ValidationResponse;
import com.aogaga.fasa.validation.Severity;
import com.aogaga.fasa.validation.ValidationRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    @Autowired
    public ValidationRules validationRules;

    private static final Logger logger = LoggerFactory.getLogger(AppController.class);


    public ValidationResponse validateApplication(Application data){
        var results = validationRules.validate(data);
        // Log each rule result
        results.forEach(r -> logger.info(
                "Rule {}: passed={} severity={}", r.getRuleCode(), r.isPassed(), r.getSeverity()
        ));
        boolean valid = results.stream()
                .noneMatch(r -> r.getSeverity() == Severity.ERROR);


        logger.info("Overall application valid: {}", valid);
        return new ValidationResponse(valid, results);
    }
}
