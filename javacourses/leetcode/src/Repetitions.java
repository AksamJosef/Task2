/**
 * Дана строка, содержащая буквы //A-Z//:
 * "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB"
 * Нужно написать функцию RLE, которая выведет строку вида:
 * "A4B3C2XYZD4E3F3A6B28"
 * Еще надо выдавать ошибку, если на ввод приходит недопустимая строка.
 * <p>
 * Примечания:
 * 1. Если символ встречается один раз, он остается неизменным
 * 2. Если символ встречается более одного раза, к нему добавляется число повторений
 */
public class Repetitions {
    public static void main(String[] args) {
        String s = "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB5";

        System.out.println(count(s));
    }

    private static String count(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int counter = 1;

        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);

            if (c < 'A' || c > 'Z') throw new IllegalArgumentException();

            if (c == s.charAt(i + 1)) {
                ++counter;
                if (i + 1 == s.length()) {
                    stringBuilder.append(c);
                    stringBuilder.append(counter);
                    break;
                }
            } else {
                stringBuilder.append(c);

                if (counter != 1) {
                    stringBuilder.append(counter);
                    counter = 1;
                }
            }
        }

        return stringBuilder.toString();
    }
}
