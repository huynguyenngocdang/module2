import java.util.HashMap;
import java.util.Map;

public class WordCount {
    private String strInput = "";

    public String getStrInput() {
        return strInput;
    }

    public void setStrInput(String strInput) {
        this.strInput = strInput;
    }

    public WordCount(String strInput) {
        this.strInput = strInput;
    }

    public void countWord () {
        Map<String, Integer> hashMap = new HashMap<>();
        String str = strInput;
        str = str.toLowerCase();
        str = str.replaceAll(" ", "");
        String[] words = str.split("");
        for (String word:words) {
            Integer integer = hashMap.get(word);
            if (integer == null) {
                hashMap.put(word, 1);
            } else{
                hashMap.put(word, integer + 1);
            }
        }
        System.out.println(hashMap);
    }
}
