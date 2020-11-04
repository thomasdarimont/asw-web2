package demo.shop.products.web;

import demo.shop.products.Product;
import demo.shop.products.ProductCataloge;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * http://localhost:8080/products
 */
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
class ProductController {

    private final ProductCataloge cataloge;

    private final ProductExcelExporter exporter;

    @GetMapping
    List<Product> list() {
        return cataloge.getProducts();
    }

    /**
     * http://localhost:8080/products/export
     */
    @GetMapping("/export")
    ResponseEntity<?> export() throws IOException {

        List<Product> products = cataloge.getProducts();

        InputStreamResource export = new InputStreamResource(exporter.exportProductList(products));

        String filename = "products.xlsx";

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "application/vnd.openxmlformats")
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + filename)
                .body(export);
    }
}
