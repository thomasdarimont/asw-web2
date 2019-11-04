package demo;

import demo.shop.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Example402DependencyInjectionSimple {

    public static void main(String[] args) {
        runSpringDependencyInjectionExample(args);
    }


    private static void runSpringDependencyInjectionExample(String[] args) {

        // Configuration via Dependency Injection
        ApplicationContext container = SpringApplication.run(Example402DependencyInjectionSimple.class, args);
        ProductService productService = container.getBean(ProductService.class);

        System.out.println();
        System.out.println(productService.findProductById("42"));
        System.out.println();
    }
}