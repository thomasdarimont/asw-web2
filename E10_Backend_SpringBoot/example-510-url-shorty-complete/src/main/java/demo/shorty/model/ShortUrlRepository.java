package demo.shorty.model;

import java.util.Optional;
import java.util.Set;

/**
 * A collection like interface to access {@link ShortUrl ShortUrl's} from a datastore.
 */
public interface ShortUrlRepository {

    Set<ShortUrl> findAll();

    ShortUrl save(ShortUrl shortUrl);

    Optional<ShortUrl> findById(String shortId);

    boolean deleteById(String shortId);
}
