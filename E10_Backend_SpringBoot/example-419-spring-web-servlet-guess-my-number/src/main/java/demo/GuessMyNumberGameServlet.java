package demo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * http://localhost:8080/game.html
 */
@WebServlet("/guess-my-number")
public class GuessMyNumberGameServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int max;
        try {
            max = Integer.parseInt(request.getParameter("max"));
        } catch (NumberFormatException nfe) {
            max = 100;
        }

        HttpSession session = request.getSession(true /* new session */);
        session.setAttribute("draw", new Random().nextInt(max));
        session.setAttribute("trialCounter", new AtomicInteger(0));
        session.setAttribute("gameOver", false);

        redirectToGamePage(response, "Try to guess my number!");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();


        if (session.getAttribute("gameOver") == null) {
            redirectToGamePage(response, "You need to start a new game first!");
            return;
        }

        boolean gameOver = Boolean.parseBoolean(String.valueOf(session.getAttribute("gameOver")));
        if (gameOver) {
            redirectToGamePage(response, "You already won! Start a new game :)");
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
        redirectToGamePage(response, hint);
    }

    private void redirectToGamePage(HttpServletResponse response, String hint) throws IOException {
        response.sendRedirect(response.encodeRedirectURL("game.html?hint=" + hint));
    }
}