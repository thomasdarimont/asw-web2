package demo.shorty.web;

import demo.shorty.model.ShortUrl;
import demo.shorty.service.ShortUrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.info.GitProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

/**
 * A Spring Web MVC Controller controls the page flow of the URL Shorter Web UI.
 */
@Controller
class ShortUrlMvcController {

    private static final Logger LOG = LoggerFactory.getLogger(ShortUrlMvcController.class);

    private final ShortUrlService service;

    private final GitProperties gitInfo;

    public ShortUrlMvcController(ShortUrlService service, GitProperties gitInfo) {
        this.service = service;
        this.gitInfo = gitInfo;
    }

    @GetMapping({"/", "/urls"})
    public String index(Model model) {

        LOG.info("show index page");

        model.addAttribute("urls", service.findAll());
        return "index";
    }

    @PostMapping("/urls/shorten")
    public String newShortUrl(@RequestParam String fullUrl) {

        LOG.info("create new shorturl");

        if (StringUtils.hasText(fullUrl)) {
            service.create(fullUrl);
        }

        return "redirect:/urls";
    }

    @GetMapping("/urls/{shortId}")
    public RedirectView find(@PathVariable String shortId) {

        LOG.info("try to find shorturl by id");

        Optional<ShortUrl> candidate = service.findById(shortId);

        return candidate.map(this::redirectToUrl)
                .orElseGet(this::redirectToNotFound);
    }

    private RedirectView redirectToUrl(ShortUrl shortUrl) {
        return new RedirectView(shortUrl.getFullUrl());
    }

    private RedirectView redirectToNotFound() {
        return new RedirectView("/error/404");
    }

    @DeleteMapping("/urls/{shortId}")
    public RedirectView delete(@PathVariable String shortId) {

        LOG.info("try to delete shorturl by id");

        service.deleteById(shortId);

        // Send a HTTP 303 See Other redirect -> this allows the browser to change the HTTP method to Get
        RedirectView redirect = new RedirectView("/urls", true);
        redirect.setHttp10Compatible(false);
        return redirect;
    }


    @GetMapping({"/about"})
    public String about(Model model) {

        LOG.info("show about page");

        model.addAttribute("version", gitInfo.get("build.version"));
        model.addAttribute("shortCommitId", gitInfo.getShortCommitId());

        return "about";
    }
}
