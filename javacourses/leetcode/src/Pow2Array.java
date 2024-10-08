import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Pow2Array {
    public static void main(String[] args) {
        int[] source = {-9, -3, 0, 2, 5, 7, 11};

        System.out.println(Arrays.toString(powArray(source)));
    }

    /*
     *  V                         V         V         V                   V          V
     * [-9] [-3] [0] [2] [5] [7] [11] -> [] [] [] [] [] [-9] [11] -> [] [-3] [0] [] [5] [-9] [11]
     *
     * */
    public static int[] powArray(int[] source) {
        int[] result = new int[source.length];

        List<Integer> list = new ArrayList<>();

        int left = 0;
        int right = source.length - 1;

        int index = right;

        while (left <= right) {
            if (Math.abs(source[left]) < Math.abs(source[right])) {
                result[index] = (int) Math.pow(source[right], 2);
//                list.add(0, (int) Math.pow(source[right], 2));
                --right;
            } else {
                result[index] = (int) Math.pow(source[left], 2);
//                list.add(0, (int) Math.pow(source[left], 2));
                ++left;
            }

            --index;
        }

        return result;
    }
}
