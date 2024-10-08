import java.time.LocalDate;
import java.time.YearMonth;

public class Primer {
    public static void main(String[] args) {
        LocalDate current = LocalDate.now().minusMonths(4);

        System.out.println(current.getMonth());

        System.out.println(current.withDayOfMonth(1));
        System.out.println(YearMonth.from(current).atEndOfMonth());
    }
}
