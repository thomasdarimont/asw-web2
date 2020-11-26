package demo;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = {"/*"})
public class TracingServletFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init filter");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // Generate requestId and mark request
        String requestId = UUID.randomUUID().toString();
        request.setAttribute("requestId", requestId);

        // Measure request processing time
        long startTime = System.currentTimeMillis();
        try {
            System.out.println(">>> Filter before request processing. requestId=" + requestId);
            chain.doFilter(request, response);
        } finally {
            System.out.printf("<<< Filter after request processing. Processing took %s ms. requestId=%s%n",
                    System.currentTimeMillis() - startTime, requestId);
        }
    }

    public void destroy() {
        System.out.println("destroy filter");
    }
}
