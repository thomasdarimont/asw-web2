package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Sessiondaten anzeigen -> Session initial leer
 * <pre>
 * {@code http://localhost:8080/session }
 * </pre>
 * <p>
 * Wert "test" mit Attribut "name" verknüpfen und in Http-Session speichern.
 * <pre>
 * {@code http://localhost:8080/session?name=test }
 * </pre>
 * <p>
 * Sessiondaten anzeigen -> Name ist jetzt "test"
 * <pre>
 * {@code http://localhost:8080/session }
 * </pre>
 * <p>
 * Sessiondaten löschen
 * <pre>
 * {@code http://localhost:8080/session?kill }
 * </pre>
 * <p>
 * Sessiondaten anzeigen -> Session sind wieder leer
 * <pre>
 * {@code http://localhost:8080/session }
 * </pre>
 *
 * <p>
 * Cookie Management: Chrome -> Developer Tools -> Application -> Cookies
 * Cookie "JSESSIONID" beinhaltet Referenz auf serverseitige Session.
 * </p>
 *
 * @author tom
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