public class Main {
    public static void main(String[] args) {
       User user = new User("huy", "123");
       UserController controller = new UserController(user);
       controller.method(StorageType.SQL);
       controller.method(StorageType.XML);
    }
}