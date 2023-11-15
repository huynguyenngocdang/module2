public class UserController {
    private UserStorage storage;
    private User currentUser;

    public UserController( User currentUser) {
        this.currentUser = currentUser;
    }

    public void method(StorageType storageType) {
            switch (storageType) {
                case SQL:
                    this.storage = new SQLStorage();
                    storage.store(currentUser);
                    break;
                case XML:
                    this.storage = new XMLStorage();
                    storage.store(currentUser);
                    break;
                default:
                    System.out.println("Invalid storageType");
                    break;
            }
    }
}
