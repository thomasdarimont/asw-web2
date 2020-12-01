package demo;

import java.io.IOException;
import java.time.LocalDateTime;

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
 * 3) Browse to http://localhost:8080/hello
 * 4) Watch for log messages from ExampleWebListener
 * 
 * Run with Jetty:
 * 1) mvn jetty:run
 * 2) Browse to http://localhost:8080/hello
 * 3) Watch for log messages from ExampleWebListener
 */
@WebServlet(urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getOutputStream().println("Hello ASW! " + LocalDateTime.now());
	}
}
