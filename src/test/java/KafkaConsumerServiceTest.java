import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kafka.to.mongodb.BookEntity;
import org.kafka.to.mongodb.BookEntityRepository;
import org.kafka.to.mongodb.KafkaConsumerService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class KafkaConsumerServiceTest {

    @Mock
    private BookEntityRepository repository;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private KafkaConsumerService consumerService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConsume() throws IOException {
        String jsonMessage = "{\"title\":\"The Great Gatsby\"," +
                "\"author\":\"F. Scott Fitzgerald\",\"publishYear\":1925,\"pages\":218}";

        BookEntity mockEntity = new BookEntity();
        mockEntity.setTitle("The Great Gatsby");
        mockEntity.setAuthor("F. Scott Fitzgerald");
        mockEntity.setPublishYear(1925);
        mockEntity.setPages(218);
        when(objectMapper.readValue(any(String.class), eq(BookEntity.class))).thenReturn(mockEntity);

        consumerService.consume(jsonMessage);

        verify(repository, times(1)).save(mockEntity);
    }
}