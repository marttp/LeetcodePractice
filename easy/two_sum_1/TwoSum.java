package easy.two_sum_1;

import java.util.HashMap;
import java.util.Map;

/**
 * TwoSum
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[] { 2, 7, 11, 15 };
        int target = 9;
        System.out.println(twoSum(nums, target));
        System.out.println(twoSumRefactor1(nums, target));
        System.out.println(twoSumRefactor2(nums, target));
        System.out.println(twoSumRefactor3(nums, target));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] output = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        return output;
    }

    /**
     * Runtime: 1 ms, faster than 99.91% of Java online submissions for Two Sum.
     * Memory Usage: 41.3 MB, less than 5.65% of Java online submissions for Two
     * Sum.
     */
    public static int[] twoSumRefactor1(int[] nums, int target) {
        Map<Integer, Integer> keyNumbers = new HashMap<>();
        int[] output = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (keyNumbers.containsKey(nums[i])) {
                if (keyNumbers.get(nums[i]) != i) {
                    output = new int[] { keyNumbers.get(nums[i]), i };
                    return output;
                }
            } else {
                keyNumbers.put(target - nums[i], i);
            }
        }
        return output;
    }

    /**
     * Runtime: 1 ms, faster than 99.91% of Java online submissions for Two Sum.
     * Memory Usage: 41.5 MB, less than 5.65% of Java online submissions for Two
     * Sum.
     */
    public static int[] twoSumRefactor2(int[] nums, int target) {
        Map<Integer, Integer> keyNumbers = new HashMap<>();
        int[] output = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (keyNumbers.containsKey(nums[i]) && keyNumbers.get(nums[i]) != i) {
                output = new int[] { keyNumbers.get(nums[i]), i };
                return output;
            } else {
                keyNumbers.put(target - nums[i], i);
            }
        }
        return output;
    }

    public static int[] twoSumRefactor3(int[] nums, int target) {
        Map<Integer, Integer> keyNumbers = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (keyNumbers.containsKey(nums[i])) {
                if (keyNumbers.get(nums[i]) != i) {
                    return new int[] { keyNumbers.get(nums[i]), i };
                }
            }
            keyNumbers.put(target - nums[i], i);
        }
        return new int[2];
    }

}