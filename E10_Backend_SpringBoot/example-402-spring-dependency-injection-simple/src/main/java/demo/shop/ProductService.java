package demo.shop;

public class ProductService {

    /**
     * Der {@link CatalogService} für Katalogabfragen.
     */
    private final CatalogService catalog;

    /**
     * Der {@link InventoryService} für Lagerbestandsinformationen.
     */
    private final InventoryService inventory;

    /**
     * @param catalog
     * @param inventory
     */
    public ProductService(CatalogService catalog, InventoryService inventory) {
        this.catalog = catalog;
        this.inventory = inventory;
    }

    public String findProductById(String id) {
        return catalog.findProductById(id) + " available: " + inventory.isProductAvailable(id);
    }
}
