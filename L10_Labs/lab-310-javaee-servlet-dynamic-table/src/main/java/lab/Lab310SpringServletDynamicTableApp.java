package lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * In der Datei HtmlTableGeneratingServlet.java implementieren Sie eine dynamische Generierung einer HTML Tabelle mit einem HttpServlet.
 *
 * <ol>
 * <li>Implementieren Sie die mit YOURCODE markierten Stellen</li>
 * </ol>
 *
 * Das Servlet können Sie über folgende URL aufrufen: http://localhost:8080/dynamic-table
 */
@SpringBootApplication
@ServletComponentScan // Required to find Servlet API components on class-path
public class Lab310SpringServletDynamicTableApp {

	public static void main(String[] args) {
		SpringApplication.run(Lab310SpringServletDynamicTableApp.class, args);
	}
}
