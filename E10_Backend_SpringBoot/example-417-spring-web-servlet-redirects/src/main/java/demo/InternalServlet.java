package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;

/**
 * This servlet is not directly accessible, since there are no URL patterns configured.
 * @author tom
 *
 */
@WebServlet(name = "internal")
public class InternalServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Boolean internal = (Boolean) req.getAttribute("internal");
        if (internal == null || !internal) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        resp.getOutputStream().println("Hello from InternalServlet " + Instant.now());
    }
}