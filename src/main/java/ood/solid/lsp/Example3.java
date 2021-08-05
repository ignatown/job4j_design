package ood.solid.lsp;

public class Example3 {

    // Пример 3.
    // Нарушение инварианта.

    public class Product {
        boolean authentic;
        public boolean isAuthentic() {
            return authentic;
        }
    }

    public class Seller{
        public void sellProduct(Product product) {
            if (!product.isAuthentic()) {
                throw new IllegalArgumentException("not authentic product");
            }
            System.out.println("Selling...");
        }
    }

    public class verifiedSeller extends Seller{
        public void sellProduct(Product product) {
            System.out.println("Selling...");
        }
    }
}
