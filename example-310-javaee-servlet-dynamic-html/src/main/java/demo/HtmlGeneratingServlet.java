package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * http://localhost:8080/example-310-javaee-servlet-dynamic-html/dynamic-list
 * 
 * http://localhost:8080/example-310-javaee-servlet-dynamic-html/dynamic-list?count=100
 */
@WebServlet("/dynamic-list")
public class HtmlGeneratingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		int count;
		try {
			count = Integer.valueOf(request.getParameter("count"));
		} catch (NumberFormatException ignored) {
			count = 10;
		}

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML>");
		out.println("<html>");
		out.println("<head><title>Dynamische Liste</title></head>");
		out.println("<body>");
		out.println("<h2>Dynamische Liste</h2>");
		out.println("<ul>");
		for (int i = 0; i < count; i++) {
			out.println(String.format("<li>Eintrag %s</li>", i));
		}
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}