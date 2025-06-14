package com.intercorp.ms01.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intercorp.ms01.model.KafkaMessageWrapper;
import com.intercorp.ms01.model.Person;
import com.intercorp.ms01.repository.PersonRepository;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final PersonRepository repository;
    private final ObjectMapper objectMapper;

    public KafkaConsumerService(PersonRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "kafka-topic-01", groupId = "group-consumer-db")
    public void consume(String message) {
        try {
          System.out.println("Mensaje recibido: " + message);

            KafkaMessageWrapper wrapper = objectMapper.readValue(message, KafkaMessageWrapper.class);
            Person person = wrapper.getPerson();
            person.setRandom(wrapper.getRandom());
            person.setRandomFloat(wrapper.getRandomFloat());
            person.setBool(wrapper.isBool());
            person.setDate(wrapper.getDate());
            person.setRegex(wrapper.getRegex());
            person.setEnumValue(wrapper.getEnumValue());
            person.setElements(wrapper.getElements());
            person.setAge(wrapper.getAge());

            if (!repository.existsByEmail(person.getEmail())) {
              repository.save(person);
          }
                      System.out.println("Guardado en DB: " + person);
        } catch (Exception e) {
          e.printStackTrace();
      }
      
    }
}
