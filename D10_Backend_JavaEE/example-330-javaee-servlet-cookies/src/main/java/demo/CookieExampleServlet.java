package demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @see http://localhost:8080/example-330-javaee-servlet-cookies/cookie
 * @see http://localhost:8080/example-330-javaee-servlet-cookies/cookie?name=test
 * @author tom
 *
 */
@WebServlet("/cookie")
public class CookieExampleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");

		if (name == null && req.getCookies() != null) {
			for (Cookie cookie : req.getCookies()) {
				if (cookie.getName().equals("name")) {
					name = cookie.getValue();
					break;
				}
			}
		} else {
			resp.addCookie(new Cookie("name", name));
		}

		resp.getWriter().printf("Hello %s%n", name);
	}
}
