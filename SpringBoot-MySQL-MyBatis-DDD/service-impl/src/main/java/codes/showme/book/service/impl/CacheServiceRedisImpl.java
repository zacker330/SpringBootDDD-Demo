package codes.showme.book.service.impl;

import codes.showme.book.service.CacheService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CacheServiceRedisImpl implements CacheService {
    @Override
    public Optional<String> getString(String key) {
        return Optional.empty();
    }
}
