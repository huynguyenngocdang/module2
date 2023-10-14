import java.util.concurrent.atomic.AtomicInteger;

public class Product {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int productId;
    private String productName;
    private double productPrice;
    private String productType;
    private String productManufacturer;
    private String productDescription;
    public Product(int productId, String productName, double productPrice, String productType, String productManufacturer) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productType = productType;
        this.productManufacturer = productManufacturer;
        this.productDescription = "This is a " + productType + " produced by " + productManufacturer;
    }

    public Product(String productName, double productPrice, String productType, String productManufacturer) {
        this.productId = count.incrementAndGet();
        this.productName = productName;
        this.productPrice = productPrice;
        this.productType = productType;
        this.productManufacturer = productManufacturer;
        this.productDescription = "This is a " + productType + " produced by " + productManufacturer;
    }

    public Product(String productName, double productPrice, String productType, String productManufacturer, String productDescription) {
        this.productId = count.incrementAndGet();
        this.productName = productName;
        this.productPrice = productPrice;
        this.productType = productType;
        this.productManufacturer = productManufacturer;
        this.productDescription = productDescription;
    }

    public Product() {

    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
        this.productPrice = productPrice;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productType='" + productType + '\'' +
                ", productManufacturer='" + productManufacturer + '\'' +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }
}
