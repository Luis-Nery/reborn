package OOProject2;

public class Product {
    private String productID;
    private String productName;
    private double productPrice;
    private int productQuantity;

    public Product(String productID, String productName, double productPrice, int productQuantity) {
        this.productID = productID;
        this.productName = productName;
        setProductPrice(productPrice);
        this.productQuantity = productQuantity;
    }

    public double sellProduct(int productQuantity) {
            if (this.productQuantity < productQuantity) {
                throw new IllegalArgumentException("Not enough stock. Available: " + this.productQuantity);
            }
        this.productQuantity -= productQuantity;
        return this.productPrice * productQuantity;
    }

    public void restockProduct(int productQuantity) {
        this.productQuantity += productQuantity;
    }

    public double applyDiscount(double percentage) {
       try{
           if(percentage >= 100 || percentage <= 0) {
            throw new  Exception("Invalid percentage");
           }else{
               percentage = percentage / 100;
               return this.productPrice * (1 - percentage);
           }
    }catch (Exception e){
           System.out.println(e.getMessage());
       }
        return this.productPrice;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
            if(productPrice<=0){
                throw new IllegalArgumentException("Product Price cannot be less than 0");
            }else{
                this.productPrice = productPrice;
            }
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        return "The product " + this.productName + " with ID: "
                + this.productID + " has in stock: " + this.productQuantity +
                " each priced at " + this.productPrice;
    }
    public static void main(String[]args){
    Product apple = new Product("Apple", "Apple", 100.0, 5);
        System.out.println(apple.getProductName());
        System.out.println(apple.getProductPrice());
        System.out.println(apple.applyDiscount(10));
    }
}
