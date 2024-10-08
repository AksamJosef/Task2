import java.util.Arrays;
import java.util.Objects;

public enum Notes {

    FIVE_THOUSAND(5000),

    ONE_THOUSAND(1000),

    FIVE_HUNDRED(500),

    ONE_HUNDRED(100),

    FIFTY(50);


    private final Integer value;


    Notes(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static Notes fromInteger(Integer value) {
        return Arrays.stream(Notes.values())
                .filter(note -> Objects.equals(note.getValue(), value))
                .findAny()
                .orElseThrow();
    }
}
