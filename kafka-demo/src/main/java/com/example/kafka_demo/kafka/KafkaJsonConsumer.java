package com.example.kafka_demo.kafka;

import com.example.kafka_demo.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonConsumer {

    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaJsonConsumer.class);

    @KafkaListener(topics="javaguides_json",groupId = "myGroup")
    public void consume(User user){
        LOGGER.info(String.format("Json message received : %s",user.toString()));
    }
}
