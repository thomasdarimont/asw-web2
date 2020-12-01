package demo;

import java.io.IOException;
import java.time.LocalDateTime;

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
 * 3) Browse to http://localhost:8080/process
 * 
 * Run with Jetty: 
 * 0) cd into example-315-javaee-tracing-servlet-filter directory
 * 1) mvn jetty:run 
 * 2) Browse to http://localhost:8080/process
 */
@WebServlet("/process")
public class ProcessingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		String requestId = (String) req.getAttribute("requestId");

		System.out.println("Start processing request. requestId=" + requestId);
		try {
			System.out.println("Pretending to do some important work for request. requestId=" + requestId);
			Thread.sleep((long) (Math.random() * 3000L));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		resp.getWriter()
				.println("Processing completed for request " + LocalDateTime.now() + ". requestId=" + requestId);
	}

}
