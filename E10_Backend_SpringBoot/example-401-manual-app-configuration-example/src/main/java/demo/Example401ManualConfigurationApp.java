package demo;

import demo.shop.CatalogService;
import demo.shop.InventoryService;
import demo.shop.ProductService;

public class Example401ManualConfigurationApp {

    public static void main(String[] args) {

        // Manual configuration:
        CatalogService catalog = new CatalogService();
        InventoryService inventory = new InventoryService();
        ProductService productService = new ProductService(catalog, inventory);
        // Note that this manual configuration gets complicated quickly:
        // common applications can consist of 100s and 1000s of different components!

        System.out.println();
        System.out.println(productService.findProductById("42"));
        System.out.println();
    }
}
