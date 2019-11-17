package demo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * http://localhost:8080/calc.html
 */
@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Called via HTTP GET with parameters passed in via URL.
     *
     * @param req
     * @param resp
     * @throws IOException
     * @see http://localhost:8080/calc_with_get.html
     * @see http://localhost:8080/calculate?n1=10&n2=30&op=add
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        process(req, resp);
    }

    /**
     * Called via HTTP POST with parameters passed in in the Request Body.
     *
     * @param req
     * @param resp
     * @throws IOException
     * @see http://localhost:8080/calc_with_post.html
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Integer n1 = Integer.parseInt(req.getParameter("n1"));
        Integer n2 = Integer.parseInt(req.getParameter("n2"));
        String op = req.getParameter("op");

        Integer result = calculate(n1, n2, op);

        resp.getWriter().printf("%s(%s,%s) = %s", op, n1, n2, result);
    }

    private Integer calculate(Integer n1, Integer n2, String op) {

        switch (op) {
            case "add":
                return n1 + n2;
            case "subtract":
                return n1 - n2;
            default:
                throw new UnsupportedOperationException("The operator " + op + " is not supported!");
        }
    }
}
