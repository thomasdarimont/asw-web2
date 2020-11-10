package demo;

import demo.shop.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Example402DependencyInjectionSimple {

    public static void main(String[] args) {

        // Zuerst starten wir den Spring Boot Container.
        // Der Container analysiert den Classpath der aktuellen Umgebung und findet die Anwendungskomponenten automatisch.
        ApplicationContext container = SpringApplication.run(Example402DependencyInjectionSimple.class, args);

        // Wir fragen den Container nach einer Instanz von Typ ProductService und bekommen eine fertig
        // konfigurierte ProductService Instanz zurück.
        // "Unter der Haube" hat Spring unseren ProductService mit einem CatalogService und InventoryService konfiguriert.
        // --> Configuration via Dependency Injection
        ProductService productService = container.getBean(ProductService.class);

        // Wir können die ProductService Instanz nun direkt verwenden.
        System.out.println();
        System.out.println(productService.findProductById("42"));
        System.out.println();
    }

}