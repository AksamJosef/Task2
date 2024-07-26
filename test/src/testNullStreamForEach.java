import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class testNullStreamForEach {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add(null);
        list.add(null);
        list.add(null);

        list.stream()
                .filter(Objects::nonNull)
                .forEach(System.out::println);
    }
}
