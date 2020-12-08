package demo.shop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.shop.catalog.CatalogService;
import demo.shop.inventory.InventoryService;

/**
 * This class is found via "Component-Scanning" and registered as a Spring Bean
 * Component.
 */
// Note: a more specialised version of @Component is @Service which implies
//additional semantics
@Component
public class ProductService {

    private final CatalogService catalog;

    private final InventoryService inventory;

    //	Note, this is just for demonstration purposes: @Autowired is not needed here as the
    // latest Spring versions automatically detect this constructor as Injection-Point!
    @Autowired 
    public ProductService(CatalogService catalog, InventoryService inventory) {
        this.catalog = catalog;
        this.inventory = inventory;
    }

    public String findProductById(String id) {
        return catalog.findProductById(id) + " available: " + inventory.isProductAvailable(id);
    }
}