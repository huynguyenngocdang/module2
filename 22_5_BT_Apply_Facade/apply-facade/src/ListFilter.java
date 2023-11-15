import java.util.ArrayList;
import java.util.List;

public class ListFilter {
    public List<Integer> filterOdd(List<Integer> inputList) {
        // Logic để loại bỏ số lẻ từ danh sách
        // Đây chỉ là một đoạn mã mẫu
        List<Integer> resultList = new ArrayList<>();
        for (Integer num : inputList) {
            if (num % 2 == 0) {
                resultList.add(num);
            }
        }
        return resultList;
    }
}