import java.util.LinkedList;
import java.util.Scanner;

public class Navigation {
    private static final Scanner scanner = new Scanner(System.in);
    private static LinkedList<Product> llProducts = ProductFile.productFileGet();
    private static int inputProductid;
    public static void choiceProductMenu() {
        int choice = -1;
        while (choice != 0) {
            Menu.menuProduct();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    llProducts.forEach(product -> System.out.println(product.toString()));
                    break;
                case 2:
                    choiceProductChange();
                    break;
                case 3:
                    System.out.println("Input product name");
                    String newName = scanner.next();
                    System.out.println("Input product price");
                    double newPrice = scanner.nextDouble();
                    System.out.println("Input product Type");
                    String newType = scanner.next();
                    System.out.println("Input product Manufacturer");
                    String newManufacturer = scanner.next();
                    int newId = getNewId(llProducts);
                    Product newProduct = new Product(newId,newName,newPrice,newType,newManufacturer);
                    llProducts.add(newProduct);
                    ProductFile.productFileSave(llProducts);
                    break;
                case 0:
                   System.exit(0);
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
    private static void choiceProductChange() {
        System.out.println("Input product id");
        inputProductid = scanner.nextInt();
        if (!isProductExist(inputProductid)) {
            System.out.println("Product not exist");
            choiceProductMenu();
        }
        Product currentProduct = getCurrentProduct(inputProductid);
        int choiceChange = -1;
        while (choiceChange != 0) {
            System.out.println(currentProduct.toString());
            Menu.menuProductChange();
            choiceChange = scanner.nextInt();
            switch (choiceChange){
                case 1:
                    System.out.println("Input new id");
                    int newId = scanner.nextInt();
                    updateProductId(currentProduct, newId);
                    Menu.menuProduct();
                    break;
                case 2:
                    System.out.println("Input new name");
                    updateProductString(currentProduct, "productName", scanner.next());
                    ProductFile.productFileSave(llProducts);
                    break;
                case 3:
                    System.out.println("Input new price");
                    updateProductPrice(currentProduct, scanner.nextDouble());
                    break;
                case 4:
                    System.out.println("Input new type");
                    updateProductString(currentProduct,"productType", scanner.next());
                    break;
                case 5:
                    System.out.println("Input new manufacturer");
                    updateProductString(currentProduct, "productManufacturer", scanner.next());
                    break;
                case 6:
                    System.out.println("Input new description");
                    updateProductString(currentProduct,"productDescription", scanner.next());
                    System.out.println();
                case 7:
                    System.out.println("Are you sure you want to remove the product? Y/N");
                    if (scanner.next().toLowerCase().equals("y")) {
                        removeProduct(currentProduct);
                        choiceProductMenu();
                    }
                case 0:
                    System.out.println("Exit change product");
                    choiceProductMenu();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
    private static void updateProductId(Product currentProduct, int newId) {
        llProducts.remove(currentProduct);
        currentProduct.setProductId(newId);
        llProducts.add(currentProduct);
        ProductFile.productFileSave(llProducts);
    }
    private static void updateProductPrice(Product currentProduct, double newPrice) {
        llProducts.remove(currentProduct);
        currentProduct.setProductPrice(newPrice);
        llProducts.add(currentProduct);
        ProductFile.productFileSave(llProducts);
    }

    private static void removeProduct(Product currentProduct) {
        llProducts.remove(currentProduct);
        ProductFile.productFileSave(llProducts);
    }

    private static void updateProductString(Product currentProduct, String productField, String newString) {
        llProducts.remove(currentProduct);
        switch (productField) {
            case "productName":
                currentProduct.setProductName(newString);
                break;
            case "productType":
                currentProduct.setProductType(newString);
                break;
            case "productManufacturer":
                currentProduct.setProductManufacturer(newString);
                break;
            case "productDescription":
                currentProduct.setProductDescription(newString);
                break;
        }
        llProducts.add(currentProduct);
        ProductFile.productFileSave(llProducts);
    }

    private static Product getCurrentProduct (int productId){
        if (isProductExist(productId)) {
            for (Product product : llProducts
            ) {
                if (product.getProductId() == productId) {
                    return product;
                }
            }
        }

        return null;
    }
    private static boolean isProductExist (int productId) {
        for (Product product:llProducts
             ) {
            if (product.getProductId() == productId) {
                return true;
            }
        }
        return  false;
    }
    private static int getNewId(LinkedList<Product> llProducts) {
        int max = 0;
        for (Product product: llProducts
             ) {
            if(max < product.getProductId()) {
                max = product.getProductId();
            }
        }
        return (max + 1);
    }

}
