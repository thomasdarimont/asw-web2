package lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Die Datei webapp/WEB-INF/jsp/system-properties.jsp enthält ein kleines Beispiel zur Erzeugung einer
 * HTML Tabelle mit JSP.
 *
 * Diesmal müssen sie das Beispiel über die Konsole starten.
 * Öffnen sie dazu ein Terminal (git bash oder cmd) im Projektverzeichnis.
 * Führen sie anschließend den folgenden Befehl aus: mvn clean spring-boot:run
 *
 * Sie können die Anwendung mit der Tastenkombination "Strg+C" stoppen.
 *
 * Sie können die JSP über folgende URL aufrufen: http://localhost:8080/system-properties
 */
@SpringBootApplication
public class Lab378SpringMvcWithJsp extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Lab378SpringMvcWithJsp.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Lab378SpringMvcWithJsp.class, args);
	}
}

@Controller
class JspController {

	@GetMapping(path="/system-properties")
	String getPage() {
		return "system-properties";
	}
}