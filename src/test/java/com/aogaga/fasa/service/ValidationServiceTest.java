package com.aogaga.fasa.service;

import com.aogaga.fasa.models.Application;
import com.aogaga.fasa.util.ValidationResponse;
import com.aogaga.fasa.validation.RuleResult;
import com.aogaga.fasa.validation.Severity;
import com.aogaga.fasa.validation.ValidationRules;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ValidationServiceTest {

    private ValidationRules validationRules;
    private ValidationService validationService;
    @BeforeEach
    void setUp() {
        validationRules = mock(ValidationRules.class);
        validationService = new ValidationService();
        validationService.validationRules = validationRules;
    }


    @Test
    void testValidateApplication_allRulesPass() {
        Application app = new Application();

        // Mock all rules passing
        when(validationRules.validate(app)).thenReturn(List.of(
                new RuleResult("AGE_001", true, "Passed", Severity.INFO),
                new RuleResult("SSN_001", true, "Passed", Severity.INFO)
        ));

        ValidationResponse response = validationService.validateApplication(app);

        assertTrue(response.isValid());
        assertEquals(2, response.getResults().size());
        response.getResults().forEach(r -> assertTrue(r.isPassed()));
    }

    @Test
    void testValidateApplication_someRulesFail() {
        Application app = new Application();

        // Mock some rules failing
        when(validationRules.validate(app)).thenReturn(List.of(
                new RuleResult("AGE_001", false, "Student too young", Severity.ERROR),
                new RuleResult("SSN_001", true, "Passed", Severity.INFO)
        ));

        ValidationResponse response = validationService.validateApplication(app);

        assertFalse(response.isValid());
        assertEquals(2, response.getResults().size());

        RuleResult ageRule = response.getResults().get(0);
        assertEquals("AGE_001", ageRule.getRuleCode());
        assertFalse(ageRule.isPassed());
        assertEquals(Severity.ERROR, ageRule.getSeverity());
    }

    @Test
    void testValidateApplication_allRulesFail() {
        Application app = new Application();

        // Mock all rules failing
        when(validationRules.validate(app)).thenReturn(List.of(
                new RuleResult("AGE_001", false, "Student too young", Severity.ERROR),
                new RuleResult("SSN_001", false, "Invalid SSN", Severity.ERROR)
        ));

        ValidationResponse response = validationService.validateApplication(app);

        assertFalse(response.isValid());
        assertEquals(2, response.getResults().size());
        response.getResults().forEach(r -> assertFalse(r.isPassed()));
        response.getResults().forEach(r -> assertEquals(Severity.ERROR, r.getSeverity()));
    }
}