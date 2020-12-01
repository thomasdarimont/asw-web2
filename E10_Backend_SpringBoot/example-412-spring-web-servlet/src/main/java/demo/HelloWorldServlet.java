package demo;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * http://localhost:8080/hello
 */
@WebServlet(urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.getOutputStream().println("Hello World! " + LocalDateTime.now());
	}
}