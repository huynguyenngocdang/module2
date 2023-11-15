public class HexObserver implements Observer{
    private int number;

    public HexObserver(int number) {
        this.number = number;
    }

    @Override
    public void update() {
        System.out.println(number + " has hex value of " + Integer.toHexString(number));
    }
}
