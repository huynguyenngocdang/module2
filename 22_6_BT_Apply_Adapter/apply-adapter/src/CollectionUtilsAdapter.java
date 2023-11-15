import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CollectionUtilsAdapter {
    public static List<Integer> convertSetToList(Set<Integer> integerSet) {
        // Chuyển đổi từ Set<Integer> sang List<Integer>
        return new ArrayList<>(integerSet);
    }
}
