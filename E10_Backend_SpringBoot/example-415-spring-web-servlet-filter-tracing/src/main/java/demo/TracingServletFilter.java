package demo;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * ServletFilter zur Ermittlung der Dauer der Request Verarbeitung.
 */
@WebFilter(urlPatterns = {"/*"})
public class TracingServletFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init filter");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // Start Zeit speichern (Millisekunden seit dem 01.01.1970 0:00 Uhr)
        long startTime = System.currentTimeMillis();
        try {
            System.out.println("## before request processing");
            chain.doFilter(request, response);
        } finally {

            // Zeit Differenz in Millisekunden ausrechnen
            long durationInMillis = System.currentTimeMillis() - startTime;
            System.out.printf("## after request processing. Processing took %s ms%n", durationInMillis);
        }
    }

    public void destroy() {
        System.out.println("destroy filter");
    }
}
