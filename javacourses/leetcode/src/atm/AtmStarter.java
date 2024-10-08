package atm;

import java.util.Map;

/**
 * Банкомат.
 * Инициализируется набором купюр и умеет выдавать купюры для заданной суммы, либо отвечать отказом.
 * При выдаче купюры списываются с баланса банкомата.
 * Допустимые номиналы: 50₽, 100₽, 500₽, 1000₽, 5000₽.
 */
public class AtmStarter {
    public static void main(String[] args) {
        Map<Integer, Integer> init = Map.ofEntries(
                Map.entry(5000, 1),
                Map.entry(1000, 2),
                Map.entry(500, 10),
                Map.entry(100, 1),
                Map.entry(50, 1)
        );

        ATM atm = new ATM(init);

        atm.withdraw(651);
        atm.showBalance();
    }
}
