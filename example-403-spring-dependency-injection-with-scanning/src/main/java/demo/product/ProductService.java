package demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.catalog.CatalogService;
import demo.inventory.InventoryService;

/**
 * This class is found via "Component-Scanning" and registered as a Spring Bean
 * Component.
 */
@Component // Note: a more specialized version of @Component is @Service which implies
			// additional semantics
public class ProductService {

	private final CatalogService catalog;

	private final InventoryService inventory;

	@Autowired // Note: just for demonstration purposes, @Autowired not needed here as the
				// latest Spring versions automatically detect this constructor as
				// Injection-Point!
	public ProductService(CatalogService catalog, InventoryService inventory) {
		this.catalog = catalog;
		this.inventory = inventory;
	}

	public String findProductById(String id) {
		return catalog.findProductById(id) + " available: " + inventory.isProductAvailable(id);
	}
}