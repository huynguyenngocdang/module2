public class Menu {
    public static void menuProduct() {
        System.out.println("""
                1. See all product
                2. Change a product
                3. Add a product
                0. Exit""");
    }
    public static void menuProductChange(){
        System.out.println("""
                1. Change product id
                2. Change product name
                3. Change product price
                4. Change product type
                5. Change product manufacturer
                6. Change product description
                7. Remove this product
                0. Exit""");
    }
}
