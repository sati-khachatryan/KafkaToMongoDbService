package org.kafka.to.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookEntityRepository extends MongoRepository<BookEntity, String> {
}