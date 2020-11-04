package lab;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @see http://localhost:8080/lab-370-javaee-servlet-filter-tracing/api/servlet2
 */
@WebServlet("/api/servlet2")
public class Servlet2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.printf("processing...%s%n", request.getRequestURI());
		
		try {
			Thread.sleep(TimeUnit.MILLISECONDS.toMillis((long)(Math.random()*1000)));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		response.getWriter().append("Hello from: ").append(request.getRequestURI());
	}
}
