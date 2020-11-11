package lab;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Das Beispiel in HttpSessionServletExample.java zeigt die Verwendung von Sessions.
 *
 * <ol>
 * <li>Beheben Sie die Java Compiler-Fehler</li>
 * <li>Implementieren Sie die mit YOURCODE markierten Stellen</li>
 * </ol>
 *
 * <pre>
 * {@code http://localhost:8080/session }
 * </pre>
 *
 * <pre>
 * {@code http://localhost:8080/session?name=test }
 * </pre>
 *
 * <pre>
 * {@code http://localhost:8080/session }
 * </pre>
 *
 * <pre>
 * {@code http://localhost:8080/session?kill }
 * </pre>
 *
 * <pre>
 * {@code http://localhost:8080/session }
 * </pre>
 *
 * <p>
 * Zur Analyse der Cookies können Sie die Browser Developer Tools verwenden:
 * Chrome: Developer Tools -> Application -> Cookies
 * </p>
 */
@SpringBootApplication
@ServletComponentScan // Required to find Servlet API components on class-path
public class Lab375SpringServletSessionApp {

	public static void main(String[] args) {
		SpringApplication.run(Lab375SpringServletSessionApp.class, args);
	}
}
