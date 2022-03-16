package vn.neo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author thanglv on 3/15/2022
 * @project logging-api
 */
@RestController
@RequestMapping("/")
public class KafkaController {
    private Logger logger = LogManager.getLogger();

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping
    public String test(@RequestParam String m) {
        kafkaTemplate.send("log-test", m);
        logger.info("Request from client: {}", m);
        return m;
    }
}
