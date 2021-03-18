package codes.showme.book.service.impl;

import codes.showme.book.service.DemoJsonProcessingException;
import codes.showme.book.vo.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class BookBuilder {

    private static final Logger logger = LoggerFactory.getLogger(BookBuilder.class);

    public static Book fromJson(String jsonString) {
        try {
            return new ObjectMapper()
                    .readerFor(Book.class)
                    .readValue(jsonString);
        } catch (JsonProcessingException e) {
            logger.error("BookBuilder fromJson error,str:{}", jsonString, e);
            throw new DemoJsonProcessingException(e);
        } catch (IOException e) {
            logger.error("BookBuilder fromJson error,str:{}", jsonString, e);
            throw new DemoJsonProcessingException(e);
        }
    }
}
