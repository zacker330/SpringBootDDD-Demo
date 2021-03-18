package codes.showme.book.domain;

import codes.showme.tech.JsonService;
import codes.showme.tech.ioc.InstanceFactory;

public class BookBuilder {
    public static Book fromJson(String jsonString) {
        JsonService jsonService = InstanceFactory.getInstance(JsonService.class);
        return jsonService.fromString(jsonString, Book.class);
    }
}
