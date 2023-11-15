import com.codegym.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Tạo một Set<Integer>
        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(10);
        integerSet.add(5);
        integerSet.add(20);

        // Chuyển đổi Set<Integer> thành List<Integer> bằng Adapter
        List<Integer> integerList = CollectionUtilsAdapter.convertSetToList(integerSet);

        // Sử dụng thư viện để tìm giá trị lớn nhất trong danh sách

        CollectionUtils collectionUtils = new CollectionUtils();
        int maxValue = collectionUtils.findMax(integerList);

        // In ra kết quả
        System.out.println("Max Value: " + maxValue);
    }
}