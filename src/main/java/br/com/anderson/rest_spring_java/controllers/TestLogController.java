package br.com.anderson.rest_spring_java.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLogController {

    private Logger logger = LoggerFactory.getLogger(TestLogController.class);

    @GetMapping("/test")
    public String testLog() {
        logger.debug("This is an DEBUG log message");
        logger.info("This is an INFO log message");
        logger.warn("This is an WARNING log message");
        logger.error("This is an ERROR log message");
        return "Logs generated successfully";
    }

}
