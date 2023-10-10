import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ProductManager {
    private LinkedList<Product> productLinkedList = new LinkedList<>();
    private Product product1 = new Product(1, "A", 100);
    private Product product2 = new Product(2, "B", 300);
    private Product product3 = new Product(3, "C", 200);

    public void addSampleProduct() {
        productLinkedList.add(product1);
        productLinkedList.add(product2);
        productLinkedList.add(product3);
    }

    public void addProduct(int id, String name, double price) {
        productLinkedList.add(new Product(id, name, price));
    }

    public void showProductList() {
        for (Product product : productLinkedList) {
            System.out.println(product.toString());
        }
    }

    public void changeProduct(int id, String name) {
        for (Product product : productLinkedList) {
            if (product.getId() == id) {
                product.setName(name);
            }
        }
    }

    public void changeProduct(int id, double price) {
        for (Product product : productLinkedList) {
            if (product.getId() == id) {
                product.setPrice(price);
            }
        }
    }

    public void removeProduct(int id) {
        for (int i = 0; i < productLinkedList.size(); i++) {
            if (productLinkedList.get(i).getId() == id) {
                productLinkedList.remove(i);
            }
        }
    }

    public void searchProduct(String name) {
        for (int i = 0; i < productLinkedList.size(); i++) {
            if (productLinkedList.get(i).getName().equals(name)) {
                System.out.println(productLinkedList.get(i).toString());
            }
        }
    }

    public void sortAsc() {
        Collections.sort(productLinkedList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() < o2.getPrice()) {
                    return -1;
                } else if (o1.getPrice() == o2.getPrice()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
    }

    public void sortDsc() {
        Collections.sort(productLinkedList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() > o2.getPrice()) {
                    return -1;
                } else if (o1.getPrice() == o2.getPrice()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
    }


}
