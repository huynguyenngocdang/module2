public class OctObserver implements Observer{
    private int number;

    public OctObserver(int number) {
        this.number = number;
    }

    @Override
    public void update() {
        System.out.println(number + " has oct value of " + Integer.toOctalString(number));
    }
}
