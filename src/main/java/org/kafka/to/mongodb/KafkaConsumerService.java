package org.kafka.to.mongodb;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class KafkaConsumerService {
    private final MongoRepository<BookEntity, String> repository;
    private final ObjectMapper objectMapper;

    @Autowired
    public KafkaConsumerService(BookEntityRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "book")
    public void consume(String message) {
        try {
            BookEntity entity = objectMapper.readValue(message, BookEntity.class);
            repository.save(entity);
            log.info("Message saved to the database: " + entity);
        } catch (IOException e) {
            log.error("Error processing JSON message: " + e.getMessage());
        }
    }


}