package codes.showme.book.service;

import java.util.Optional;

public interface CacheService {
    Optional<String> getString(String bookCacheKeyString);
}
