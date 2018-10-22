package demo.catalog;

import org.springframework.stereotype.Component;

/**
 * This class is found via "Component-Scanning" and registered as a Spring Bean
 * Component.
 */
@Component
public class CatalogService {

	public String findProductById(String id) {
		return "Product: " + id;
	}
}