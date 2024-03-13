package org.kafka.to.mongodb;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "entity_book")
public class BookEntity {
    private String title;
    private String author;
    private int publishYear;
    private int pages;
    private final LocalDate added = LocalDate.now();


    @Override
    public String toString() {
        return "title:%s, author:%s, publishYear:%s, pages:%s."
                .formatted(title, author, publishYear, pages);
    }
}
