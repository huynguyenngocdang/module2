import java.util.Scanner;

public class Translator extends Subject{


    public void translate(int number) {
        Observer observerBin = new BinObserver(number);
        Observer observerHex = new HexObserver(number);
        Observer observerOct = new OctObserver(number);
        addObserver(observerBin);
        addObserver(observerHex);
        addObserver(observerOct);
        notifyObserver();
        removeObserver(observerBin);
        removeObserver(observerHex);
        removeObserver(observerOct);
    }
}
