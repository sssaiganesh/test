package EcommerceAPI;

public class ElectronicsProduct extends Product {
    private String brand;

    public ElectronicsProduct(int id, String name, double price, String brand) {
        super(id, name, price);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
