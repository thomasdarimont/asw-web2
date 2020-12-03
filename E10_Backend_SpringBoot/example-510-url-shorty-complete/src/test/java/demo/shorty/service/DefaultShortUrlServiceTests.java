package demo.shorty.service;

import demo.shorty.model.ShortUrl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DefaultShortUrlServiceTests {

    @Autowired
    DefaultShortUrlService shortyService;

    @Test
    void thereShouldBeNoUrlsOnStart() {
        assertThat(shortyService.findAll()).isEmpty();
    }

    @Test
    void createAndFindAll() {

        ShortUrl shortUrl = shortyService.create("https://google.de");
        assertThat(shortUrl).isNotNull();

        Set<ShortUrl> urls = shortyService.findAll();
        assertThat(urls).isNotEmpty();
        assertThat(urls).hasSize(1);
    }

    @Test
    void createAndFindOne() {

        ShortUrl shortUrl = shortyService.create("https://google.de");

        Optional<ShortUrl> found = shortyService.findById(shortUrl.getShortId());

        assertThat(found).isNotEmpty();
        assertThat(found).contains(shortUrl);
    }

    @Test
    void createAndDeleteOne() {

        ShortUrl shortUrl = shortyService.create("https://google.de");

        shortyService.deleteById(shortUrl.getShortId());

        Optional<ShortUrl> found = shortyService.findById(shortUrl.getShortId());
        assertThat(found).isEmpty();
    }
}
