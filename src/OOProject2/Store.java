package OOProject2;

import java.util.ArrayList;
import java.util.HashMap;

public class Store {
    private String storeName;
    private HashMap<String,Product> products;
    public Store(String storeName) {
        this.storeName = storeName;
        this.products = new HashMap<>();
    }
    public void addProduct(Product product) {
        this.products.put(product.getProductID(), product);
    }
    public void sellProduct(String productID, int quantity) {
        this.products.get(productID).sellProduct(quantity);
    }
    public String getStoreName() {
        return storeName;
    }
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    public void displayInventory() {
        for (Product product : this.products.values()) {
            System.out.println(product.getProductName());
        }
    }

    public HashMap<String, Product> getProducts() {
        return products;
    }

    public void setProducts(HashMap<String, Product> products) {
        this.products = products;
    }

    public static void main(String[] args) {
        Store store = new Store("Ataraxia");
        store.addProduct(new Product("P001", "Laptop", 999.99, 10));
        store.addProduct(new Product("P002", "Mouse", 29.99, 50));
        store.sellProduct("P001",2);
        store.displayInventory();      // Shows all products
    }

}
