package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * http://localhost:8080/cookie
 * http://localhost:8080/cookie?name=test
 * <p>
 * http://localhost:8080/cookie?kill
 *
 * See this tutorial for modern cookie handling in Spring Boot: https://attacomsian.com/blog/cookies-spring-boot
 */
@WebServlet("/cookie")
public class CookieExampleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    private static final String COOKIE_NAME = "mycookie";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");

        // store value of name parameter in cookie
        if (name != null) {
            // send new cookie to store name in browser
            Cookie newCookie = new Cookie(COOKIE_NAME, name);

            // cookie valid for 1 hour
            newCookie.setMaxAge(60 * 60);

            // send cookie with response
            resp.addCookie(newCookie);

            resp.sendRedirect("/cookie");
            return;
        }

        // search for cookie
        Cookie mycookie = findCookie(req, COOKIE_NAME);

        if (mycookie == null) {
            resp.getWriter().println("Cookie nicht gefunden.");
            return;
        }

        // delete cookie in browser
        if (req.getParameter("remove") != null) {
            Cookie emptyCookie = new Cookie(COOKIE_NAME, null);

            // force cookie deletion
            emptyCookie.setMaxAge(0);

            // send empty cookie with response
            resp.addCookie(emptyCookie);

            resp.getWriter().println("Cookie gelöscht!");
            return;
        }

        // show cookie value
        resp.getWriter().println("Hello " + mycookie.getValue());

    }

    private Cookie findCookie(HttpServletRequest req, String cookieName) {

        // do we have any cookies?
        if (req.getCookies() == null) {
            return null;
        }

        // search for our cookie in request cookies
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals(cookieName)) { // do we have OUR cookie?
                return cookie;
            }
        }

        // we could not find our cookie
        return null;
    }
}