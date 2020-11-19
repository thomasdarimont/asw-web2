package lab;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// ???? // YOURCODE Use the proper Annotation for Servlets
public class GuessMyNumberGameServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	//called for HTTP GET
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Random random = new Random();
		int max;
		try {
			String maxParam = 
				// ????; // YOURCODE use the request parameter max 
				null; // remove this line
			max = Integer.parseInt(maxParam); 
		} catch (NumberFormatException nfe) {
			max = 100;
		}

		HttpSession session = request.getSession(true /* new session */);
		
		//YOURCODE set the session attributes correctly
		// session.????("draw", random.nextInt(max));
		// session.????("trialCounter", new AtomicInteger(0));
		// session.????("gameOver", false);

		 //YOURCODE set the request hint attribute correctly
		// request.????("hint", "Try to guess my number!");

		forwardToGameJsp(request, response);
	}

	//called for HTTP POST
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = 
			// ???? ;//YOURCODE access the HTTP SESSION from the request
			null; // remove this line

		//YOURCODE extract the "gameOver" attribute from the HTTP SESSION
		String gameOverString = 
			// String.valueOf(session.??(??));
			null; // remove this line

		if (gameOverString == null) {
			request.setAttribute("hint", "You need to start a new game first!");
			forwardToGameJsp(request, response);
			return;
		}

		//YOURCODE extract the "gameOver" attribute from the HTTP SESSION
		boolean gameOver = Boolean.parseBoolean(gameOverString);
		if (gameOver) {
			request.setAttribute("hint", "You already won! Start a new game :)");
			forwardToGameJsp(request, response);
			return;
		}

		int trials = ((AtomicInteger) session.getAttribute("trialCounter")).incrementAndGet();
		int guess = Integer.parseInt(request.getParameter("guess"));
		int draw = (Integer) session.getAttribute("draw");

		String hint;
		if (guess == draw) {
			hint = String.format("Congratulations! You found: %s. It took you %s guesses", guess, trials);
			session.setAttribute("gameOver", true);
		} else if (guess < draw) {
			hint = String.format("Your number %s is too low...", guess);
		} else {
			hint = String.format("Your number %s is too high...", guess);
		}
		//YOURCODE set "hint" request attribute to hint
		// request.set????(????,????);

		forwardToGameJsp(request, response);
	}

	void forwardToGameJsp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//YOURCODE get requestDispatcher for /game from request and forward the request/response
        // request.????(??,??);
	}
}