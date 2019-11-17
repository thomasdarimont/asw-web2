package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @see http://localhost:8080/redirect-ext?redirect_uri=https://www.google.de
 */
@WebServlet("/redirect-ext")
public class ExternalRedirectionServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String redirectUri = req.getParameter("redirect_uri");
        resp.sendRedirect(redirectUri); // sends a 302 Temporary Redirect
    }
}
