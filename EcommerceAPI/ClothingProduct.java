package EcommerceAPI;

public class ClothingProduct extends Product {
    private String size;

    public ClothingProduct(int id, String name, double price, String size) {
        super(id, name, price);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
