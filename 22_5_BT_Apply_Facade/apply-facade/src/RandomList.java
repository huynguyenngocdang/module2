import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomList {
    public List<Integer> generateList(int size) {
        // Logic để tạo danh sách số nguyên ngẫu nhiên
        // Đây chỉ là một đoạn mã mẫu
        Random random = new Random();
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            resultList.add(random.nextInt(100)); // Giả sử giới hạn số ngẫu nhiên là 100
        }
        return resultList;
    }
}