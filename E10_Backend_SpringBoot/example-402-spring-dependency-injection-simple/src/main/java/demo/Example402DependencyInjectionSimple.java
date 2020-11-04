package demo;

import demo.shop.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Example402DependencyInjectionSimple {

    public static void main(String[] args) {

        // Spring Boot Container starten. Der Container analysiert den Classpath und "entdeckt" die Anwendungskomponenten automatisch.
        ApplicationContext container = SpringApplication.run(Example402DependencyInjectionSimple.class, args);

        // Wir fragen den Container nach einer Instanz von ProductService und bekommen eine fertig konfigurierte Instanz zurück.
        // --> Configuration via Dependency Injection
        ProductService productService = container.getBean(ProductService.class);

        // Wir können nun die Instanz direkt verwenden.
        System.out.println();
        System.out.println(productService.findProductById("42"));
        System.out.println();
    }

}