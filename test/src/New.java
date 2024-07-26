import java.util.Optional;

public class New {
    public static boolean isBlank(CharSequence cs) {
        int strLen = (cs).length();
        if (strLen == 0) {
            return true;
        } else {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    protected static String getNotBlankString(String value) {
        return Optional.ofNullable(value)
                .filter(x -> !isBlank(x))
                .orElse("NOT_EXISTED_FIELD");
    }

    public static void main(String[] args) {
        System.out.println(getNotBlankString(null));
    }

}

