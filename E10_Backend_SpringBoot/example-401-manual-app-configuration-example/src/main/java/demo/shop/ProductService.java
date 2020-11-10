package demo.shop;

public class ProductService {

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
