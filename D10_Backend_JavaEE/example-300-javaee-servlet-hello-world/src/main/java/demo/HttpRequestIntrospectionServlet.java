package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Simple Servlet that shows information about the current HTTP Request.
 * 
 * Run via with Jetty from Eclipse:
 * 0) select example-300-javaee-servlet-hello-world project (if not already running)
 * 	1) Run as maven build...
 * 	2) Goals: jetty:run
 * 3) Browse to http://localhost:8080/introspect/test?param1=hallo&param2=welt 
 */
@WebServlet("/introspect/*")
public class HttpRequestIntrospectionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String httpMethod = req.getMethod();
		String requestUri = req.getRequestURI();

		String queryString = req.getQueryString();

		PrintWriter out = resp.getWriter();

		out.println("<h1>Request Line</h1>");
		out.printf("%s %s?%s %s%n", httpMethod, requestUri, queryString.replaceAll("&", "&amp;"), req.getProtocol());
		out.println();

		out.println("<h2>Request Headers</h2>");
		out.println("<ul>");
		for (String headerName : Collections.list(req.getHeaderNames())) {
			String headerValue = req.getHeader(headerName);
			out.printf("<li>%s: %s</li>%n", headerName, headerValue);
		}
		out.println("</ul>");

		out.println("<h2>Request Parameters</h2>");
		out.println("<ul>");
		for (String parameterName : Collections.list(req.getParameterNames())) { // req.getParameterMap()
			String parameterValue = Arrays.toString(req.getParameterValues(parameterName));
			out.printf("<li>%s=%s</li>%n", parameterName, parameterValue);
		}
		out.println("</ul>");

		out.println("Request Body");
		out.println("<pre>");
		try (Scanner scanner = new Scanner(req.getReader())) {
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
		}
		out.println("</pre>");
	}
}
