import java.util.Optional;

import static java.util.function.UnaryOperator.identity;

public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> empty = Optional.empty();
        Optional<String> notEmpty = Optional.of("I am not empty!!!!");

        System.out.println("EMPTY is empty: " + empty.isEmpty());
        System.out.println("EMPTY is present: " + empty.isPresent());

        System.out.println("NOT_EMPTY is empty: " + notEmpty.isEmpty());
        System.out.println("NOT_EMPTY is present: " + notEmpty.isPresent());

        System.out.println();
        if (empty.isPresent()) {
            System.out.println(empty.get());
        } else {
            System.out.println();
        }

        empty.map(ne -> {
            System.out.println(ne);
            return identity();
        });

    }
}
