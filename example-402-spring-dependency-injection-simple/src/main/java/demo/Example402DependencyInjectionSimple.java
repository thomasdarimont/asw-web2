package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class Example402DependencyInjectionSimple {

	public static void main(String[] args) {

		runManualConfigurationExample();

//		runSpringDependencyInjectionExample(args);
	}

	private static void runManualConfigurationExample() {
		// Manual configuration;
		ProductService productService = new ProductService(new CatalogService(), new InventoryService());

		System.out.println();
		System.out.println(productService.findProductById("42"));
		System.out.println();
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

class ProductService {

	private final CatalogService catalog;

	private final InventoryService inventory;

	public ProductService(CatalogService catalog, InventoryService inventory) {
		this.catalog = catalog;
		this.inventory = inventory;
	}

	public String findProductById(String id) {
		return catalog.findProductById(id) + " available: " + inventory.isProductAvailable(id);
	}
}

class CatalogService {

	public String findProductById(String id) {
		return "Product: " + id;
	}
}

class InventoryService {

	public boolean isProductAvailable(String id) {
		return Math.random() > 0.5;
	}
}

@Configuration
class ProductConfig {

	@Bean
	public ProductService productService(CatalogService catalog, InventoryService inventory) {
		return new ProductService(catalog, inventory);
	}

	@Bean
	public CatalogService catalogService() {
		return new CatalogService();
	}

	@Bean
	public InventoryService inventoryService() {
		return new InventoryService();
	}
}
