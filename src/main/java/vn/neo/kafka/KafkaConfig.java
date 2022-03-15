package vn.neo.kafka;

import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * @author thanglv on 3/15/2022
 * @project logging-api
 */
@Component
public class KafkaConfig {

    @KafkaListener(topics = "log-test", groupId = "group-id")
    public void test(String message) {
        System.out.println("==================> Listen from kafka: " + message);
    }
}
