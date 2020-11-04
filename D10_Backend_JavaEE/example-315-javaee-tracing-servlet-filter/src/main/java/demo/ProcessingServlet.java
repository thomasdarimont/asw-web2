package demo;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @see http://localhost:8080/example-315-javaee-tracing-servlet-filter/process
 */
@WebServlet("/process")
public class ProcessingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Processing request...");
		try {
			Thread.sleep((long) (Math.random() * 1000L));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		resp.getWriter().println("Processing completed " + LocalDateTime.now());
	}

}
