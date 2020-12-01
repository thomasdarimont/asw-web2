package demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
 * 3) Browse to http://localhost:8080/redirect-int
 * 
 * Run with Jetty:
 * 1) mvn jetty:run
 * 2) Browse to http://localhost:8080/redirect-int
 */
@WebServlet("/redirect-int")
public class InternalRedirectionServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	// index.jsp is "hidden" in /WEB-INF/secret and cannot be accessed directly! 
    	// Therefore, we use a RequestDispatcher to forward the current (request,response) pair internally.  
    	
        // redirects internally (no HTTP redirect)
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/secret/index.jsp");
        dispatcher.forward(req, resp);
    }
}
