import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";

        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> lettersQuantity = new HashMap<>();

        for (int i = 0; i < ransomNote.length(); i++) {
            lettersQuantity.merge(ransomNote.charAt(i), 1, Integer::sum);
        }

        for (int i = 0; i < magazine.length(); i++) {
            Integer quantity = lettersQuantity.get(magazine.charAt(i));
            if (quantity == null || quantity == 0) {
                return false;
            }

            lettersQuantity.merge(ransomNote.charAt(i), -1, Integer::sum);
        }

        return true;
    }
}
