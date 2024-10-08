import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};

        int target = 9;

        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int lowBorder = 0;
        int upBorder = nums.length - 1;

        while (lowBorder <= upBorder) {
            int middle = (lowBorder + upBorder) / 2;

            if (nums[middle] < target) {
                lowBorder = middle + 1;
            } else if (nums[middle] > target) {
                upBorder = middle - 1;
            } else {
                return middle;
            }
        }

        return -1;
    }

}
