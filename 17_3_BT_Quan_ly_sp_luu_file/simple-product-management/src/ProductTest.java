
import java.util.LinkedList;

public class ProductTest {
    public static void main(String[] args) {
        LinkedList<Product> llProductsWrite = new LinkedList<>();
        llProductsWrite.add(new Product("Iphone7s", 120, "Phone", "Apple"));
        llProductsWrite.add(new Product("Iphone15", 240, "Phone", "Apple"));
        ProductFile.productFileSave(llProductsWrite);
       LinkedList<Product> llProductsRead = ProductFile.productFileGet();
       llProductsRead.forEach(product -> System.out.println(product.toString()));


    }
}
