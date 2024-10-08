import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * Банкомат.
 * Инициализируется набором купюр и умеет выдавать купюры для заданной суммы, либо отвечать отказом. 
 * При выдаче купюры списываются с баланса банкомата.
 * Допустимые номиналы: 50₽, 100₽, 500₽, 1000₽, 5000₽.
 */
class ATM {

    private final Map<Notes, Integer> bank;

    public ATM(Map<Notes, Integer> bank) {
        this.bank = bank;
    }

    public Map<Notes, Integer> withdraw(Integer value) {
        checkValue(value);

        Map<Notes, Integer> result = new EnumMap<>(Notes.class);

        List<Integer> notes = Arrays.stream(Notes.values())
                .map(Notes::getValue)
                .toList();

        for (Integer note : notes) {
            Notes localKey = Notes.fromInteger(note);

            while (value >= note) {

                Integer quantity = bank.get(localKey);

                if (quantity == null || quantity == 0) {
                    break;
                }

                value -= note;

                bank.merge(localKey, -1, Integer::sum);
                result.merge(localKey, 1, Integer::sum);
            }

            if (value == 0) {
                return result;
            }
        }

        result.entrySet().forEach(entry -> bank.merge(entry.getKey(), entry.getValue(), Integer::sum));

        throw new RuntimeException("Ошибка: не хватает купюр в банкомате.");
    }

    public void print() {
        System.out.println("ТЕКУЩЕЕ СОСТОЯНИЕ БАНКОМАТА:");

        bank.entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
    private void checkValue(Integer value) {
        if (value <= 0 || value % 50 != 0) {
            throw new RuntimeException("Данная сумма не может быть выдана, т.к. она не кратна 50 или равна нулю");
        }
    }
}