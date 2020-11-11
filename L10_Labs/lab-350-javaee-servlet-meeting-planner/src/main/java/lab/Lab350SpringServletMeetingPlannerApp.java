package lab;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * In AttendeeRegistrationServlet.java implementieren Sie die Logik für ein einfaches Registrierungsformular.
 *
 * <ol>
 * <li>Beheben Sie die Java Compiler-Fehler</li>
 * <li>Implementieren Sie die mit YOURCODE markierten Stellen</li>
 * </ol>
 *
 * Die Datei registration.html findet sich im Verzeichnis src/main/resources/static
 *
 * Das Servlet können Sie über folgende URL aufrufen: http://localhost:8080/registration.html
 */
@SpringBootApplication
@ServletComponentScan // Required to find Servlet API components on class-path
public class Lab350SpringServletMeetingPlannerApp {

	public static void main(String[] args) {
		SpringApplication.run(Lab350SpringServletMeetingPlannerApp.class, args);
	}
}
