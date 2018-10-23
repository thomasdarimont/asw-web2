package lab;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <ol>
 * <li>Kopieren Sie den Inhalt in eine neue Java Klasse namens
 * AttendeeRegistrationServlet im selben package</li>
 * <li>Implementieren Sie die mit YOURCODE markierten Stellen</li>
 * </ol>
 * 
 * @see http://localhost:8080/lab-350-javaee-servlet-meeting-planner/registration.html
 */
@WebServlet("/registration")
public class AttendeeRegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final Set<Attendee> attendees = Collections.synchronizedSet(new LinkedHashSet<>());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		printAttendeeListing(response.getWriter());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		String name = request.getParameter("name"); // YOURCODE read parameter from request
		String email = request.getParameter("email"); // YOURCODE read parameter from request

		Attendee inputAttendee = new Attendee(name, email);
		boolean wasNew = attendees.add(inputAttendee);

		String status = wasNew ? " hinzugef&uuml;gt" : "aktualisiert";

		PrintWriter out = response.getWriter();

		out.println(String.format("<h2>Teilnehmer %s %s</h2>", inputAttendee, status));

		printAttendeeListing(out);
	}

	private void printAttendeeListing(PrintWriter out) {

		out.println("<p>Neuen Teilnehmer <a href=\"registration.html\">registerien</a>?</p>");
		/*
		 * YOURCODE -1 is not correct - determine the correct number of
		 * registered attendees! 
		 * Hint: find out how to determine the number of entries in a Collection.
		 */
		out.println(String.format("<h2>Anzahl Teilnehmer %s</h2>", attendees.size()));
		out.println("<h2>Liste der Teilnehmer</h2>");

		// YOURCODE start the ordered list here
		out.println("<ol>");
		for (Attendee attendee : attendees) {
			// YOURCODE create the list item element here.
			// Note format the list item text like: Eintrag: Attendee [name=tom, email=test@localhost]
			// hint use the toString() representation of Attendee
			out.println("<li>" + attendee +"</li>");
		}
		// YOURCODE end the ordered list here
		out.println("</ol>");
	}
}
