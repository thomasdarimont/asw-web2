package demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @see http://localhost:8080/example-328-javaee-servlet-redirects/redirect-ext?redirect_uri=http://www.google.de
 * @author tom
 *
 */
@WebServlet("/redirect-ext")
public class ExternalRedirectionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String redirectUri = req.getParameter("redirect_uri");
		resp.sendRedirect(redirectUri); // sends a 302 Temporary Redirect
	}
}
