package lab;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// Add the proper Annotation for Servlet Filters
@WebFilter(urlPatterns = { "/api/*" }) // We want to filter all Requests starting with /api use * as wildcard
public class TracingServletFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init filter");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		long startTime = System.currentTimeMillis();
		try {
			System.out.println("## before request processing");
			chain.doFilter(request, response);
		} finally {
			System.out.printf("## after request processing. Processing took %s ms%n", System.currentTimeMillis() - startTime);
		}
	}

	public void destroy() {
		System.out.println("destroy filter");
	}
}
