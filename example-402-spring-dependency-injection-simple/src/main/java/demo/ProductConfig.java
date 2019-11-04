package demo;

import demo.shop.CatalogService;
import demo.shop.InventoryService;
import demo.shop.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
