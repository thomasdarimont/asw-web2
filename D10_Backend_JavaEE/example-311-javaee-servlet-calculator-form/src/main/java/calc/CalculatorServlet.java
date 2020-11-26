package calc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Run with Jetty:
 * 0) cd into example-300-javaee-servlet-hello-world directory
 * 1) mvn jetty:run
 * 2) Browse to http://localhost:8080/calc.html
 */
@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Called via HTTP GET with parameters passed in via URL.
	 * 
	 * http://localhost:8080/calc_with_get.html
	 * 
	 * http://localhost:8080/calculate?n1=10&n2=30&op=add
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) //
			throws ServletException, IOException {
		doPost(req, resp);
	}

	/**
	 * Called via HTTP POST with parameters passed in in the Request Body.
	 * 
	 * http://localhost:8080/calc_with_post.html
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) //
			throws ServletException, IOException {

		Integer n1 = Integer.valueOf(req.getParameter("n1"));
		Integer n2 = Integer.valueOf(req.getParameter("n2"));
		String op = req.getParameter("op");

		Integer result;

		switch (op) {
		case "add":
			result = n1 + n2;
			break;
		case "subtract":
			result = n1 - n2;
			break;
		default:
			result = null;
		}
		
		System.out.printf("Got %s %s %s = %s via HTTP %s%n", n1 , op, n2, result, req.getMethod());

		resp.getWriter().printf("%s(%s,%s) = %s", op, n1, n2, result);
	}
}
