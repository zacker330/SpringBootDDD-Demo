package codes.showme.tech.impl;

import codes.showme.tech.JsonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JsonServiceJacksonImpl implements JsonService {

    private static final Logger logger = LoggerFactory.getLogger(JsonServiceJacksonImpl.class);

    @Override
    public Map<String, Object> toMap(Object object) {
        final ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(object, Map.class);
    }

    @Override
    public <T> T fromMap(Map<String, Object> map, Class<T> clasz) {
        final ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(map, clasz);
    }

    @Override
    public String toJsonString(Object object) {
        final ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error("JsonServiceJacksonImpl toJsonString error,o:{}", object, e);
            throw new codes.showme.tech.JsonProcessingException(e);
        }
    }

    @Override
    public <T> T fromString(String jsonString, Class<T> tClass) {
        try {
            return new ObjectMapper()
                    .readerFor(tClass)
                    .readValue(jsonString);
        } catch (JsonProcessingException e) {
            logger.error("JsonServiceJacksonImpl fromString error,str:{}", jsonString, e);
            throw new codes.showme.tech.JsonProcessingException(e);
        }

    }
}
