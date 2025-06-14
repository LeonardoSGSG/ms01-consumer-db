package com.intercorp.ms01.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intercorp.ms01.model.Person;
import com.intercorp.ms01.repository.PersonRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final PersonRepository repository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public KafkaConsumerService(PersonRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "kafka-topic-01", groupId = "ms01-consumer-group")
    public void consume(String message) {
        try {
            Person person = objectMapper.readValue(message, Person.class);
            repository.save(person);
            System.out.println("Guardado en DB: " + person);
        } catch (Exception e) {
            System.err.println("Error al procesar mensaje: " + e.getMessage());
        }
    }
}
