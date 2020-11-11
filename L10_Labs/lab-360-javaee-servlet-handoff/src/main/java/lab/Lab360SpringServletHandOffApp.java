package lab;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Einfaches Beispiel für die Datenweitergabe zwischen den Servlets EingabeServlet -> VerarbeitungsServlet -> AusgabeServlet.
 * <ol>
 * <li>Beheben Sie zuerst die Java Compiler-Fehler!</li>
 * <li>Implementieren Sie die mit YOURCODE markierten Stellen</li>
 * <li>Beginnen sie mit EingabeServlet.java</li>
 * </ol>
 *
 * Das Servlet können Sie über folgende URL aufrufen: http://localhost:8080/handoff/eingabe?a=1&b=2
 */
@SpringBootApplication
@ServletComponentScan // Required to find Servlet API components on class-path
public class Lab360SpringServletHandOffApp {

	public static void main(String[] args) {
		SpringApplication.run(Lab360SpringServletHandOffApp.class, args);
	}
}
