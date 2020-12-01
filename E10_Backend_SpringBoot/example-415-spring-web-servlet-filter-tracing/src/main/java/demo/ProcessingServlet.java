package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @see http://localhost:8080/process
 */
@WebServlet("/process")
public class ProcessingServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


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
