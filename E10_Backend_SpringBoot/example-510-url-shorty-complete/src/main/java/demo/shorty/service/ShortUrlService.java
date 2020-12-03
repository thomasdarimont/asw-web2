package demo.shorty.service;

import demo.shorty.model.ShortUrl;

import java.util.Optional;
import java.util.Set;

/**
 * A {@link ShortUrlService} to manage {@link ShortUrl ShortUrls}.
 */
public interface ShortUrlService {

    Set<ShortUrl> findAll();

    ShortUrl create(String fullUrl);

    Optional<ShortUrl> findById(String shortId);

    boolean deleteById(String shortId);
}
