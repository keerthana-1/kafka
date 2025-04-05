package com.example.kafka_demo.controller;

import com.example.kafka_demo.kafka.KafkaJsonProducer;
import com.example.kafka_demo.payload.User;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JSONMessageController {

    private KafkaJsonProducer kafkaJsonProducer;

    public JSONMessageController(KafkaJsonProducer kafkaJsonProducer){
        this.kafkaJsonProducer=kafkaJsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        kafkaJsonProducer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }
}
