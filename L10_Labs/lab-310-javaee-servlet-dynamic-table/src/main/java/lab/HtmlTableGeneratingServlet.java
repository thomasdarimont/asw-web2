package lab;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <ol>
 * <li>Implementieren Sie die mit YOURCODE markierten Stellen</li>
 * </ol>
 * 
 * @see http://localhost:8080/dynamic-table
 */
@WebServlet("/dynamic-table")
public class HtmlTableGeneratingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		int columns = getIntParameterWithFallback("cols", 2, request);
		int rows = getIntParameterWithFallback("rows", 3, request);

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML>");
		out.println("<html>");
		out.println("<head><title>Dynamische Tabelle</title></head>");
		out.println("<body>");
		out.println("<h2>Dynamische Tabelle</h2>");
		
		// we use the String.format(...) method to "render" a value into a String, that might come in handy later...
		// The first String parameter is the "template". The template can contain placeholders (like %s for Strings and other types...).
		// The placeholders are provided by the parameters following the template string. They parameter values are inserted at corresponding placeholder indices.
		// String.format("Hallo %s", "Welt") results in the String "Hallo Welt".
		// String.format("%s schöne %s", "Hallo", "Welt") results in the String "Hallo schöne Welt".
		out.println(String.format("<h3>Dynamische Tabelle mit %s Spalten und %s Zeilen</h3>", columns, rows));
		out.println("<table>");
		out.println("<thead>");
		for (int i = 0; i < columns; i++) {
			out.println(String.format("<th>Spalte %s</th>", i));
		}
		out.println("</thead>");
		out.println("<tbody>");
		Random random = new Random();
		
		
		for (int row = 0; row < rows; row++) {
		
			// YOURCODE start a new table-row element here
			
			for (int column = 0; column < columns; column++) {
				// YOURCODE generate new random value by calling: random.nextInt(1024)
				// YOURCODE generate <td> element with random value here
			}
			
			// YOURCODE end the table-row element here
		}
		out.println("</tbody>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	private int getIntParameterWithFallback(String name, int fallbackValue, HttpServletRequest request) {
		try {
			// YOURCODE read request parameter with the given name
			return Integer.parseInt(request.getPar?????(name));
		} catch (NumberFormatException ignored) {
			return fallbackValue;
		}
	}
}