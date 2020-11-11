package lab;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session")
public class HttpSessionServletExample extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		if (req.getParameterMap().containsKey("kill")) {
			if (session != null) {
				session.invalidate();
			}
			resp.getWriter().printf("Session removed!");
			return;
		}

		String name = req.getParameter("name");

		if (name == null) {
			name = (String) session.getAttribute("name");
		} else {
			session.setAttribute("name", name);
		}

		resp.getWriter().printf("Hello %s%n", name);
	}
}