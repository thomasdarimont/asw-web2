package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import demo.product.ProductService;

@SpringBootApplication
public class Example403DependencyInjectionWithScanning {

	public static void main(String[] args) {

		// Spring "scans" the classpath for Bean components (annotated with @Component)
		ApplicationContext container = SpringApplication.run(Example403DependencyInjectionWithScanning.class, args);
		
		// Configuration via Dependency Injection
		ProductService productService = container.getBean(ProductService.class);

		System.out.println();
		System.out.println(productService.findProductById("42"));
		System.out.println();
	}
}