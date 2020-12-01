package demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * http://localhost:8080/redirect-int
 */
@WebServlet("/redirect-int")
public class InternalRedirectionServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	// Forward the (request, response) pair to the internally available servlet "internal"
        RequestDispatcher dispatcher = req.getRequestDispatcher("internal");
        req.setAttribute("internal", true);
        dispatcher.forward(req, resp);
    }
}
