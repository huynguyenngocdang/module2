public class BinObserver implements Observer{
    private int number;

    public BinObserver(int number) {
        this.number = number;
    }

    @Override
    public void update() {
        System.out.println(number + " has binary value of " + Integer.toBinaryString(number));
    }
}
