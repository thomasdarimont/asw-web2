package lab;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/handoff/verarbeitung")
public class VerarbeitungsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.printf("Running in %s%n", getClass().getSimpleName());

		Integer a = 
			// (Integer) req.???("internalA"); // Read internal attribute internalA
			null; // remove this line

		Integer b = 
			// (Integer) req.???("internalB"); // Read internal attribute internalB
			null; // remove this line

		Integer sum = a + b;

		req.setAttribute("sum", sum);

		RequestDispatcher rd = 
				// req.???("/handoff/ausgabe"); // obtain request dispatcher
				null; // remove this line

		rd.forward(req, resp);
	}
}
