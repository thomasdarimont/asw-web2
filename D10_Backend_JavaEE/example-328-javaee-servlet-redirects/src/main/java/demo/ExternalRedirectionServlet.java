package demo;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * Run via with Jetty from Eclipse:
 * 0) select project
 * 1) Run as maven build...
 * 2) Goals: jetty:run
 * 3) Browse to http://localhost:8080/redirect-ext?redirect_uri=http://www.google.de
 * 
 * Run with Jetty:
 * 1) mvn jetty:run
 * 2) Browse to http://localhost:8080/redirect-ext?redirect_uri=http://www.google.de
 */
@WebServlet("/redirect-ext")
public class ExternalRedirectionServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String redirectUri = req.getParameter("redirect_uri");

        // sends a 302 Temporary Redirect
        resp.sendRedirect(redirectUri);
    }
}
