package demo.shorty.service;

import demo.shorty.model.ShortUrl;
import demo.shorty.model.ShortUrlRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@Service
class DefaultShortUrlService implements ShortUrlService {

    private final ShortUrlRepository repository;

    public DefaultShortUrlService(ShortUrlRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<ShortUrl> findAll() {
        return repository.findAll();
    }

    @Override
    public ShortUrl create(String fullUrl) {
        String shortId = createShortId(fullUrl);
        ShortUrl shortUrl = new ShortUrl(shortId, fullUrl, LocalDateTime.now());
        return repository.save(shortUrl);
    }

    private String createShortId(String fullUrl) {
        return Integer.toHexString(fullUrl.hashCode());
    }

    @Override
    public Optional<ShortUrl> findById(String shortId) {
        return repository.findById(shortId).map(this::incrementClickCounter);
    }

    private ShortUrl incrementClickCounter(ShortUrl shortUrl) {
        return shortUrl.clicked();
    }

    @Override
    public boolean deleteById(String shortId) {
        return repository.deleteById(shortId);
    }
}
