package demo;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Simple Hello World Servlet that shows a message
 * 
 * Run via with Jetty from Eclipse:
 * 0) select example-300-javaee-servlet-hello-world project
 * 1) Run as maven build...
 * 2) Goals: jetty:run
 * 3) Browse to http://localhost:8080/hello
 *
 * Run with Jetty from CLI:
 * 0) cd into example-300-javaee-servlet-hello-world directory
 * 1) mvn jetty:run
 * 2) Browse to http://localhost:8080/hello

 * 
 * Run with Tomcat:
 * 0) cd into example-300-javaee-servlet-hello-world directory
 * 1) mvn clean package
 * 2) copy target/*.war to $TOMCAT_HOME/webapps
 * 3) start tomcat via $TOMCAT_HOME/startup.bat
 * 4) Browse to http://localhost:8080/example-300-javaee-servlet-hello-world/hello
 * 
 */
@WebServlet(urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String message = "Hello ASW! " + LocalDateTime.now();
		System.out.println(message);
		resp.getOutputStream().println(message);
	}
}
