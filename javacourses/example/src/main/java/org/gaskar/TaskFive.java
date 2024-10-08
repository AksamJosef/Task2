package org.gaskar;

import java.util.Arrays;

public class TaskFive {
    public static void main(String[] args) {
        int[] source = {5, 2, 1, 6, 2, 10, 3, 2};
        int[] sourceNull = null;
        int[] sourceMT = {};
        System.out.println(Arrays.toString(sort(source)));
        System.out.println(Arrays.toString(sort(sourceNull)));
        System.out.println(Arrays.toString(sort(sourceMT)));
    }

    public static int[] sort(int[] sourceArray) throws MyException {
        if (sourceArray == null || sourceArray.length == 0) throw new MyException("что-то пошло не так v2.0");

        for (int i = 0; i < sourceArray.length; i++) {
            for (int j = 0; j < sourceArray.length; j++) {
                if (sourceArray[i] < sourceArray[j]) {
                    int temp = sourceArray[i];
                    sourceArray[i] = sourceArray[j];
                    sourceArray[j] = temp;
                }
            }
        }
        int[] result = sourceArray;

        return result;
    }

}
