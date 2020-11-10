package training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@SpringBootApplication
public class Lab110HttpRequestsExampleServerApp {

    public static void main(String[] args) {
        SpringApplication.run(Lab110HttpRequestsExampleServerApp.class, args);
    }
}

@RestController
class LabIndexController {

    @GetMapping("/")
    Object index() {
        return "Lab Server " + Instant.now();
    }
}

@RestController
@RequestMapping("/ex")
class LabHttpExercisesController {

    @GetMapping("/get-plain")
    public Object getPlain() {
        return "Success!";
    }

    @GetMapping("/get-with-query-parameters")
    public ResponseEntity<?> getWithQueryParameters(@RequestParam(required = false) String first, @RequestParam(required = false) String second) {

        if (first == null || second == null) {
            return ResponseEntity.badRequest().body("Error! Missing or invalid URL parameters: Please send two parameters 'first' and 'second'");
        }

        if (!first.equals("mono")) {
            return ResponseEntity.badRequest().body("Error! Invalid URL parameter: 'first' required value: 'mono'");
        }

        if (!second.equals("flux")) {
            return ResponseEntity.badRequest().body("Error! Invalid URL parameter: 'second' required value: 'flux'");
        }

        return ResponseEntity.ok("Success!");
    }

    @PostMapping(path = "/process-form-data", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.ALL_VALUE})
    public ResponseEntity<?> processFormData(@RequestHeader(name = HttpHeaders.CONTENT_TYPE, required = false) String contentType, @RequestParam Map<String, String> body) {

        if (!MediaType.APPLICATION_FORM_URLENCODED_VALUE.equals(contentType)) {
            return ResponseEntity.badRequest().body("Error! Missing or invalid content-type header: Please use the content-type 'application/x-www-form-urlencoded'");
        }

        String first = body.get("first");
        String second = body.get("second");

        if (first == null || second == null) {
            return ResponseEntity.badRequest().body("Error! Missing or invalid form parameters: Please send two parameters 'first' and 'second'");
        }

        if (!first.equals("blue")) {
            return ResponseEntity.badRequest().body("Error! Invalid form parameter: 'first' required value: 'blue'");
        }

        if (!second.equals("green")) {
            return ResponseEntity.badRequest().body("Error! Invalid form parameter: 'second' required value: 'green'");
        }

        return ResponseEntity.ok().body("Success!");
    }

    @GetMapping("/content-negotiation")
    public ResponseEntity<?> contentNegotiation(@RequestHeader(name = HttpHeaders.ACCEPT, required = false) String acceptHeader) {

        if (acceptHeader == null) {
            return ResponseEntity.badRequest().body("Error! Missing Header: Send an 'Accept' header with 'application/json' or 'application/xml'");
        }

        if (MediaType.APPLICATION_JSON_VALUE.equals(acceptHeader)) {
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).body("{'message':'Success!'}");
        } else if (MediaType.APPLICATION_XML_VALUE.equals(acceptHeader)) {
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE).body("<message>Success!</message>");
        }

        return ResponseEntity.badRequest().body("Error! Missing Header: Send an 'Accept' header with 'application/json' or 'application/xml'");
    }
}
