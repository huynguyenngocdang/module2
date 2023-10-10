public class Menu {
    public static void printMenu() {
        System.out.println("""
                                
                Main Menu
                1. Add a product
                2. Change a product by id
                3. Remove a product by id
                4. Show product list
                5. Search product by name
                6. Sort product with price increase
                7. Sort product with price decrease
                0. Exit                                
                """);
    }

    public static void printChangeMenu() {
        System.out.println("""
                1. Change product name
                2. Change product price
                0. Exit""");
    }

    public static void printInputProductID() {
        System.out.println("Input product id: ");
    }

    public static void printInputProductName() {
        System.out.println("Input product name: ");
    }

    public static void printInputProductPrice() {
        System.out.println("Input product price: ");
    }

    public static void printInvalid() {
        System.out.println("Invalid");
    }

    public static void printExit() {
        System.out.println("Exiting");
    }
}
