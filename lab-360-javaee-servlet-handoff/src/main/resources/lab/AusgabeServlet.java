package lab;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/handoff/ausgabe")
public class AusgabeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.printf("Running in %s%n", getClass().getSimpleName());

		Integer a = (Integer) req.getAttribute("internalA");
		Integer b = (Integer) req.getAttribute("internalB");
		Integer sum = (Integer) req.getAttribute("sum");

		// %s Platzhalter für einen String
		// %n Platzhalter für newline
		resp.getWriter().printf("%s + %s = %s%n", a, b, sum);
	}
}