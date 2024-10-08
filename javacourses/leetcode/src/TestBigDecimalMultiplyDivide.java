import java.math.BigDecimal;
import java.math.RoundingMode;

public class TestBigDecimalMultiplyDivide {
    public static void main(String[] args) {
        BigDecimal value = BigDecimal.valueOf(1000.0);

        System.out.println(value.multiply(BigDecimal.valueOf(0.1))
                .divide(BigDecimal.ONE.add(BigDecimal.valueOf(0.1)), RoundingMode.HALF_UP)
                .setScale(2, RoundingMode.HALF_UP));


    }
}
