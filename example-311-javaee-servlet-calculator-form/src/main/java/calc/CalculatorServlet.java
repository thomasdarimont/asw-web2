package calc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Called via HTTP GET with parameters passed in via URL.
	 * 
	 * @see http://localhost:8080/example-311-javaee-servlet-calculator-form/calc_with_get.html
	 * 
	 * @see http://localhost:8080/example-311-javaee-servlet-calculator-form/calculate?n1=10&n2=30&op=add
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
	 * @see http://localhost:8080/example-311-javaee-servlet-calculator-form/calc_with_post.html
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

		resp.getWriter().printf("%s(%s,%s) = %s", op, n1, n2, result);
	}
}
