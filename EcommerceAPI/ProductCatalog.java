package EcommerceAPI;

import EcommerceAPI.ClothingProduct;
import EcommerceAPI.DuplicateProductException;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
    private List<Product> products;

    public ProductCatalog() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (products.contains(product)) {
            throw new DuplicateProductException("EcommerceAPI.Product with ID " + product.getId() + " already exists");
        }
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    public List<Product> getProductsByName(String name) {
        List<Product> matchingProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equals(name)) {
                matchingProducts.add(product);
            }
        }
        return matchingProducts;
    }

    public List<ClothingProduct> getClothingProductsBySize(String size) {
        List<ClothingProduct> matchingClothingProducts = new ArrayList<>();
        for (Product product : products) {
            if (product instanceof ClothingProduct && ((ClothingProduct) product).getSize().equals(size)) {
                matchingClothingProducts.add((ClothingProduct) product);
            }
        }
        return matchingClothingProducts;
    }
}
