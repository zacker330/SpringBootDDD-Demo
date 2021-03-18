package codes.showme.tech;

import java.util.Map;

public interface JsonService {

    Map<String, Object> toMap(Object object);

    <T> T fromMap(Map<String, Object> map, Class<T> clasz);

    String toJsonString(Object object);

    <T> T fromString(String jsonString, Class<T> tClass);

    class OsslJsonProcessingException extends RuntimeException{
        public OsslJsonProcessingException(Throwable cause) {
            super(cause);
        }
    }
}
