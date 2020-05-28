package array.contains_duplicate;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    // time complexity: O(n), space complexity: O(n)
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);

        for (int num : nums) {
            if (set.contains(num)) return true;

            set.add(num);
        }
        return false;
    }

    // time complexity: O(n log n), space complexity: O(n=1)
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3, 1};

        boolean result = solution.containsDuplicate(nums);
        System.out.println(result);

        boolean result2 = solution.containsDuplicate2(nums);
        System.out.println(result2);
    }
}
