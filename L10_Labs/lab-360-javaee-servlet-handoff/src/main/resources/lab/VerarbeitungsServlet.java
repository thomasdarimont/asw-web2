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

		Integer a = (Integer) req.getAttribute("internalA"); // Read internal attribute internalA
		Integer b = (Integer) req.getAttribute("internalB"); // Read internal attribute internalB

		Integer sum = a + b;

		req.setAttribute("sum", sum);

		RequestDispatcher rd = req.getRequestDispatcher("/handoff/ausgabe"); // obtain request dispatcher
		rd.forward(req, resp);
	}
}