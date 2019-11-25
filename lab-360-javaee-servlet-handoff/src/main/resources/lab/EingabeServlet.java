package lab;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @see http://localhost:8080/handoff/eingabe
 */
//Use the proper Annotation for Servlets
@WebServlet("/handoff/eingabe")
public class EingabeServlet extends HttpServlet {  // use the proper Base-class for Servlets

	private static final long serialVersionUID = 1L;

	// Hint: we need to handle HTTP GET Requests with this method
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.printf("Running in %s%n", getClass().getSimpleName());

		if (req.getParameter("a") == null || req.getParameter("b") == null) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parameters missing!");
			return;
		}

		Integer a = Integer.valueOf(req.getParameter("a"));
		Integer b = Integer.valueOf(req.getParameter("b"));

		req.setAttribute("internalA", a);
		req.setAttribute("internalB", b);

		RequestDispatcher rd = req.getRequestDispatcher("/handoff/verarbeitung");
		rd.forward(req, resp);
	}
}
