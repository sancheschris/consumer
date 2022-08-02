package com.live.kafka.consumer.consumer;

import com.live.kafka.consumer.DTO.CarDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CarConsumer {

    @Value(value = "${topic.name}")
    private String topic;

    @Value(value = "${spring.kafka.consumer.group-id}")
    private String groupId;

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.consumer.group-id", containerFactory = "carKafkaListenerContainerFactory")
    public void ListenTopicCar(ConsumerRecord<String, CarDTO> record) {
        log.info("Received Message " + record.partition());
        log.info("Received Message" + record.value());

    }

}
