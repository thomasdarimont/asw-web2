package demo.shop;

public class InventoryService {

	public boolean isProductAvailable(String id) {
		return Math.random() > 0.5;
	}
}
