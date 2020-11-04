package demo;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        if (req.getParameter("kill") != null) {
            Cookie cookieToDelete = new Cookie("name", "");
            cookieToDelete.setMaxAge(0);
            resp.addCookie(cookieToDelete);
            resp.getOutputStream().println("Cookie deleted!");
            return;
        }

        String name = req.getParameter("name");

        if (name == null && req.getCookies() != null) {
            for (Cookie cookie : req.getCookies()) {
                if (cookie.getName().equals("name")) {
                    name = cookie.getValue();
                    break;
                }
            }
        } else {
            Cookie nameCookie = new Cookie("name", name);
//            nameCookie.setHttpOnly(true); // true = make cookie unaccessible from javascript
            nameCookie.setPath("/"); // global cookie accessible everywhere from the current domain
            resp.addCookie(nameCookie);
        }

        resp.getWriter().printf("Hello %s%n", name);
    }
}