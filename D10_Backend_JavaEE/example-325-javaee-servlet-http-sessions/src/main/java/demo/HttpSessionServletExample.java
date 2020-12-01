package demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Run via with Jetty from Eclipse:
 * 0) select project
 * 1) Run as maven build...
 * 2) Goals: jetty:run
 * 3) Browse to the URLs listed below
 * 4) Watch for log messages from ExampleWebListener
 * 
 * Run with Jetty from console:
 * 1) mvn jetty:run
 * 
 * 2) Browse to http://localhost:8080/session and inspect cookies ->  JSessionID cookie should be present, take note of sessionId
 * 3) Browse to http://localhost:8080/session?name=World to set the name attribute in the session to "test"
 * 4) Browse to http://localhost:8080/session and inspect cookies -> now we should see name read from the session
 * 5) Browse to http://localhost:8080/session?kill inspect cookies ->  there should now be a NEW JSessionID cookie
 * 6) Browse to http://localhost:8080/session?name=ASW to start anew
 *
 * To inspect cookies, you can use the Browser Dev Tools
 * <p>
 * Cookie Management: Chrome -> Developer Tools -> Application -> Cookies
 * </p>
 * 
 * @author tom
 *
 */
@WebServlet("/session")
public class HttpSessionServletExample extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		if (req.getParameterMap().containsKey("kill")) {
			if (session != null) {
				session.invalidate();
			}
			resp.getWriter().printf("Session removed!");
			return;
		}

		String name = req.getParameter("name");

		if (name == null) {
			name = (String) session.getAttribute("name");
		} else {
			session.setAttribute("name", name);
		}

		resp.getWriter().printf("Hello %s%n", name);
	}
}