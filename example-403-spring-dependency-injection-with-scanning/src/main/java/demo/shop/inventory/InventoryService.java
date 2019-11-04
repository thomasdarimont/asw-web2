package demo.shop.inventory;

import org.springframework.stereotype.Component;

/**
 * This class is found via "Component-Scanning" and registered as a Spring Bean
 * Component.
 */
@Component
public class InventoryService {

	public boolean isProductAvailable(String id) {
		return Math.random() > 0.5;
	}
}