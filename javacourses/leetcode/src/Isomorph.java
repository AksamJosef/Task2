import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Даны две строки s и t. Определите изоморфны ли они.
 * <p>
 * Определение:
 * Две строки s и t называются изоморфными, если можно сделать замену символов в строке s,
 * чтобы получить строку t, при этом:
 * Все вхождения заменяемого символа должны быть заменены заменяющим символом
 * Никакие два разных символа не могут быть заменены на один и тот же символ
 * Символ может быть заменен сам на себя
 * <p>
 * <p>
 * Примеры:
 * s = "egg", t = "add" -> True
 * s = "foo", t = "bar" -> False
 * s = "paper", t = "title" -> True
 */
public class Isomorph {
    public static void main(String[] args) {
        String s = "privet";
        String t = "privat";

        System.out.println(isIsomorphic(s, t));
    }

    private static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            sMap.merge(s.charAt(i), 1, Integer::sum);
            tMap.merge(t.charAt(i), 1, Integer::sum);
        }

        System.out.println(sMap);
        System.out.println(tMap);

        Collection<Integer> values = tMap.values();

        for (var key: sMap.keySet()) {
            if (!values.contains(sMap.get(key))) {
                return false;
            }
        }

        return true;
    }
}
