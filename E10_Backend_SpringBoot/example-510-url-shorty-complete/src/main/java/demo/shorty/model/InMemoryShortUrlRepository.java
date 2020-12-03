package demo.shorty.model;

import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Default {@link ShortUrlRepository} implemenation that stores {@link ShortUrl ShortUrls} in memory.
 */
@Repository
class InMemoryShortUrlRepository implements ShortUrlRepository {

    private final Set<ShortUrl> URLS = Collections.synchronizedSet(new LinkedHashSet<>());

    @Override
    public Set<ShortUrl> findAll() {
        return Collections.unmodifiableSet(URLS);
    }

    @Override
    public ShortUrl save(ShortUrl shortUrl) {
        URLS.add(shortUrl);
        return shortUrl;
    }

    @Override
    public Optional<ShortUrl> findById(String shortId) {
        return URLS.stream()
                .filter(shortyUrl -> shortId.equals(shortyUrl.getShortId()))
                .findFirst();
    }

    @Override
    public boolean deleteById(String shortId) {
        return URLS.removeIf(s -> s.getShortId().equals(shortId));
    }
}
