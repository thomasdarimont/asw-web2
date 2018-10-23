package lab;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = { "/api/*" })
public class TracingServletFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init filter");
	}

	public void destroy() {
		System.out.println("destroy filter");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;

		long startTime = System.currentTimeMillis();
		try {
			System.out.printf( //
					"## before request processing: %s%n", //
					httpRequest.getRequestURI() //
			);
			chain.doFilter(request, response);
		} finally {
			System.out.printf( //
					"## after request processing: %s. Processing took %s ms%n", //
					httpRequest.getRequestURI(), //
					System.currentTimeMillis() - startTime //
			);
		}
	}
}
