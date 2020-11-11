package lab;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * In TracingServletFilter.java sollen sie eine Zeitmessung für die HTTP Request-Verarbeitung mit einem ServletFilter implementieren.
 * <ol>
 * <li>Beheben Sie die Java Compiler-Fehler</li>
 * <li>Implementieren Sie die mit YOURCODE markierten Stellen</li>
 * </ol>
 *
 * In diesem Beispiel sind 3 Servlets enthalten die sie mit folgenden URLs aufrufen können:
 * <ul>
 *     <li>http://localhost:8080/api/servlet1  Mit Zeitmessung</li>
 *     <li>http://localhost:8080/api/servlet2  Mit Zeitmessung</li>
 *     <li>http://localhost:8080/doc/servlet3  Ohne Zeitmessung</li>
 * </ul>
 */
@SpringBootApplication
@ServletComponentScan // Required to find Servlet API components on class-path
public class Lab370SpringServletFilterTracingApp {

	public static void main(String[] args) {
		SpringApplication.run(Lab370SpringServletFilterTracingApp.class, args);
	}
}
