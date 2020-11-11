package lab;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// YOURCODE Use the proper Annotation for Servlets
@???("/handoff/eingabe")
public class EingabeServlet extends ??? { // use the proper Base-class for Servlets 

	private static final long serialVersionUID = 1L;

	// Hint: we need to handle HTTP GET Requests with this method
	@Override
	protected void ???(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.printf("Running in %s%n", getClass().getSimpleName());

		if (req.getParameter("a") == null || req.getParameter("b") == null) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parameters a or b are missing!");
			return;
		}

		Integer a = Integer.valueOf(req.???("a")); // read parameter a from request
		Integer b = Integer.valueOf(req.???("b")); // read parameter b from request

		req.setAttribute("internalA", a); // pass value of parameter a as internal attribute internalA to other servlets 
		req.setAttribute("internalB", b); // ~ ...

		RequestDispatcher rd = req.getRequestDispatcher("/handoff/verarbeitung");
		rd.forward(req, resp);
	}
}
