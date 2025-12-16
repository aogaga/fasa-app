package com.aogaga.fasa.controller;

import com.aogaga.fasa.models.Application;
import com.aogaga.fasa.service.ValidationService;
import com.aogaga.fasa.util.ValidationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AppController {
    private static final Logger logger = LoggerFactory.getLogger(AppController.class);

    @Autowired
    private ValidationService validationService;

    @GetMapping
    public String get() {
        return "Hello foole";
    }

    @PostMapping
    public ValidationResponse processFasaApp(@RequestBody Application data){
        logger.info("Received POST request with application data: {}", data);

        return validationService.validateApplication(data);
    }

}
