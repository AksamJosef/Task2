package atm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Банкомат
 */
public class ATM {

    private static final List<Integer> availableNotes = List.of(5000, 1000, 500, 100, 50);

    private final Map<Integer, Integer> notes;

    public ATM(Map<Integer, Integer> initValues) {
        this.notes = new HashMap<>();
        init(initValues);

    }

    private void init(Map<Integer, Integer> initValues) {
        initValues.forEach((k, v) -> {
            if (!availableNotes.contains(k)) {
                throw new RuntimeException("Невозможно инициализировать банкомат: переданные значения содержат недопустимые купюры");
            }

            notes.put(k, v);
        });
    }

    public void withdraw(Integer value) {
        checkAvailability(value);

        for (Integer available : availableNotes) {
            if (notes.get(available) == null) {
                continue;
            }

            while (value - available >= 0) {
                if (notes.get(available) == 0) {
                    break;
                }

                notes.merge(available, -1, Integer::sum);

                value -= available;

                if (value == 0) {
                    System.out.println("Деньги успешно сняты");

                    return;
                }
            }
        }

        throw new RuntimeException("Невозможно снять деньги");
    }

    private void checkAvailability(Integer value) {
        if (value <= 0 || value % 50 != 0)
            throw new RuntimeException("Невозможно снять сумму " + value + " т.к. она не кратна 50 у.е");
    }

    public void showBalance() {
        notes.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
