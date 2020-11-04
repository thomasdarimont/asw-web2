package demo;

import demo.shop.CatalogService;
import demo.shop.InventoryService;
import demo.shop.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Diese Klasse beschreibt die Anwendungskomponenten mit deren Abhängigkeiten.
 */
@Configuration // Diese Annotation markiert die Klasse als Konfigurationsklasse (JavaConfig) für Spring Boot
class ProductConfig {

    /**
     * Bean-Definition von ProductService.
     *
     * Eine Instanz von ProduktService benötigt eine Instanz von CatalogService und eine Instanz des InventoryService.
     * Die benötigten Instanzen werden automatisch vom Spring Container bereitgestellt.
     * Um die benötigten Instanzen zu erzeugen, werden die beiden mit @Bean annotierten Methoden vom Spring Container aufgerufen.
     *
     * @param catalog
     * @param inventory
     * @return
     */
    @Bean
    public ProductService productService(CatalogService catalog, InventoryService inventory) {
        return new ProductService(catalog, inventory);
    }

    /**
     * Bean-Definition von CatalogService.
     *
     * Der Spring Container ruft diese Methode auf um eine Instanz von CatalogService zu erzeugen.
     * Standardmäßig erzeugt Spring sogenannte Singleton-Instanzen, d.h. es wird nur eine Objektinstanz in der Anwendung geben.
     * Dieses Verhalten kann man über die @Scope Annotation anpassen.
     *
     * @return
     */
    @Bean
    public CatalogService catalogService() {
        return new CatalogService();
    }

    /**
     * Bean-Definition von InventoryService.
     */
    @Bean
    public InventoryService inventoryService() {
        return new InventoryService();
    }
}
