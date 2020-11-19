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

// YOURCODE Use the proper Annotation for Servlets
// @???("/registration")
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

		// take a look at static/registration.html to find out the proper parameter names for name and email
		String name = 
				//request.???(???); // YOURCODE read the name parameter from request
				null; // remove this line
		String email = 
				// request.???(???); // YOURCODE read the email parameter from request
				null; // remove this line

		Attendee inputAttendee = new Attendee(name, email);
		boolean wasNew = attendees.add(inputAttendee);

		String status = wasNew ? " hinzugef&uuml;gt" : "aktualisiert";

		PrintWriter out = response.getWriter();

		out.println(String.format("<h2>Teilnehmer %s %s</h2>", inputAttendee, status));

		printAttendeeListing(out);
	}

	private void printAttendeeListing(PrintWriter out) {

		out.println("<p>Neuen Teilnehmer <a href=\"registration.html\">registrieren</a>?</p>");
		/*
		 * YOURCODE determine the correct number of registered attendees! 
		 * Hint: find out how to determine the size of the attendees Collection.
		 */
		int attendeeCount = 
				// attendees.?????();
				-1; // remove this line
		out.println(String.format("<h2>Anzahl Teilnehmer %s</h2>", attendeeCount));
		out.println("<h2>Liste der Teilnehmer</h2>");

		// YOURCODE start the ordered list html-element here
		for (Attendee attendee : attendees) {
			// YOURCODE create the list item element here.

			// Note format the list item text-content like: Eintrag: Attendee [name=tom, email=test@localhost]
			// hint use the toString() representation of Attendee

			// YOURCODE end the list item element here.
		}
		// YOURCODE end the ordered list html-element here
	}
}
