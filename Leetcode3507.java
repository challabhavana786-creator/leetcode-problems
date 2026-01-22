import java.util.*;
public class Leetcode3507 {
    private static boolean isNonDecreasing(List<Integer> nums) {
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < nums.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
    public static int minimumOperations(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        int operations = 0;
        while (!isNonDecreasing(list)) {
            int minSum = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    index = i;
                }
            }
            list.set(index, minSum);
            list.remove(index + 1);
            operations++;
        }
        return operations;
    }
    public static void main(String[] args) {
        int[] nums1 = {5, 2, 3, 1};
        System.out.println(minimumOperations(nums1)); // Output: 2
        int[] nums2 = {1, 2, 2};
        System.out.println(minimumOperations(nums2)); // Output: 0
    }
}