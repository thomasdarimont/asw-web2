package lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * In der Datei GuessMyNumberGameServlet.java sollen sie ein kleines Zahlenratespiel implementieren.
 *
 * <ol>
 * <li>Beheben Sie die Java Compiler-Fehler</li>
 * <li>Implementieren Sie die mit YOURCODE markierten Stellen</li>
 * </ol>
 *
 * Diesmal müssen sie das Beispiel über die Konsole starten.
 * Öffnen sie dazu ein Terminal (git bash oder cmd) im Projektverzeichnis.
 * Führen sie anschließend den folgenden Befehl aus: mvn clean spring-boot:run
 *
 * Sie können die Anwendung mit der Tastenkombination "Strg+C" stoppen.
 *
 * Sie können das Zahlenratespiel über die folgende URL aufrufen: http://localhost:8080/guess-my-number
 */
@SpringBootApplication
@ServletComponentScan // Required to find Servlet API components on class-path
public class Lab390SpringMvcWithJspGuessMyNumberGame extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Lab390SpringMvcWithJspGuessMyNumberGame.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Lab390SpringMvcWithJspGuessMyNumberGame.class, args);
	}
}

@Controller
class JspController {

	@RequestMapping(path = "/game", method = {RequestMethod.GET, RequestMethod.POST})
	String getPage() {
		return "game";
	}
}