package array.two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    // time complexity: O(n), space complexity: O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement))
                return new int[] { map.get(complement), i };

            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution found");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        Solution solution = new Solution();
        int[] twoSums = solution.twoSum(nums, target);

        System.out.println(Arrays.toString(twoSums));
    }
}
