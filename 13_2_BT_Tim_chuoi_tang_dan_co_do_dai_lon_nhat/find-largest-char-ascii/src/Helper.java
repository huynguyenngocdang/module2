import java.util.Collections;
import java.util.LinkedList;

public class Helper {
    private String strInput;

    private LinkedList<Integer> llNumbers;
    private LinkedList<String> llStrInput;
    private LinkedList<String> llStrResult;

    public Helper(String strInput) {
        this.strInput = strInput;
        this.llNumbers = new LinkedList<>();
        this.llStrInput = new LinkedList<>();
       this.llStrResult = new LinkedList<>();
    }

    public String getStrInput() {
        return strInput;
    }

    public void setStrInput(String strInput) {
        this.strInput = strInput;
    }

    public void inputString() {
        for (int i = 0; i < this.strInput.length(); i++) {
            this.llStrInput.push(String.valueOf(this.strInput.charAt(i)));
        }
    }

    public void convertToASCII() {
        inputString();
        for (int i = 0; i < this.strInput.length(); i++) {
            int ascii = (int) this.strInput.charAt(i);
            this.llNumbers.push(ascii);
        }
    }


   public void printSortNumbers() {
       Collections.sort(llNumbers, (o1, o2) -> o1 - o2);
       for (int number: llNumbers
       ) {

           System.out.print(number + " ");

       }
       System.out.println();
       for (int i = 0; i < llNumbers.size(); i++) {
           String str = String.valueOf(Character.toChars(llNumbers.get(i)));
           System.out.print(str + " ");
       }
   }
    public void printNumbersConvert() {
        for (int number: llNumbers
             ) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public int sumTotal(LinkedList<Integer> llNumbers) {
        int result = 0;
        for (int number: llNumbers
             ) {
            result += number;
        }
        return  result;
    }
    public void printTotal() {
        System.out.println(sumTotal(this.llNumbers));
    }
    public void printResult() {
        int sum = sumTotal(this.llNumbers);
        int currSum = 0;
        Collections.sort(llNumbers, (o1, o2) -> o1 - o2);
        for (int i = 0; i < this.llNumbers.size(); i++) {
            if ( currSum < sum - currSum) {
                currSum += Integer.valueOf(this.llNumbers.get(i));
                String currChar = String.valueOf(Character.toChars(llNumbers.get(i)));
                llStrResult.addLast(currChar);
            } else {
                break;
            }
        }
        for (String currChar: llStrResult
             ) {
            System.out.print(currChar);
        }
    }



}
