import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addSampleProduct();
        int choice = -1;


        while (choice != 0) {
            Menu.printMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Menu.printInputProductID();
                    int id = scanner.nextInt();
                    Menu.printInputProductName();
                    String name = scanner.nextLine();
                    Menu.printInputProductPrice();
                    double price = scanner.nextDouble();
                    productManager.addProduct(id, name, price);

                    break;
                case 2:
                    Menu.printChangeMenu();
                    int choiceChange = scanner.nextInt();
                    switch (choiceChange) {
                        case 1:
                            Menu.printInputProductID();
                            int idChangeName = scanner.nextInt();
                            Menu.printInputProductName();
                            String nameChange = scanner.next();
                            productManager.changeProduct(idChangeName, nameChange);
                            break;
                        case 2:
                            Menu.printInputProductID();
                            int idChangePrice = scanner.nextInt();
                            Menu.printInputProductName();
                            double priceChange = scanner.nextDouble();
                            productManager.changeProduct(idChangePrice, priceChange);
                            break;
                        case 0:
                            Menu.printExit();
                            break;
                        default:
                            Menu.printInvalid();
                            break;
                    }
                    break;
                case 3:
                    Menu.printInputProductID();
                    int idRemove = scanner.nextInt();
                    productManager.removeProduct(idRemove);
                    break;
                case 4:
                    productManager.showProductList();
                    break;
                case 5:
                    Menu.printInputProductName();
                    String nameSearch = scanner.next();
                    productManager.searchProduct(nameSearch);
                    break;
                case 6:
                    productManager.sortAsc();
                    break;
                case 7:
                    productManager.sortDsc();
                    break;
                case 0:
                    Menu.printExit();
                    break;
                default:
                    Menu.printInvalid();
                    break;


            }

        }
    }
}