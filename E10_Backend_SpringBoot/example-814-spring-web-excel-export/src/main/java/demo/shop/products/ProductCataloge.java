package demo.shop.products;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductCataloge {

    public List<Product> getProducts() {
        return List.of(
                new Product(1L, "A", netPrice("1.99")),
                new Product(2L, "B", netPrice("2.45")),
                new Product(3L, "C", netPrice("0.99"))
        );
    }

    private static BigDecimal netPrice(String price) {
        return new BigDecimal(price);
    }
}
