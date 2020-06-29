package dynamic_programming.maximum_subarray;

public class Solution {
    // time complexity: O(n), space complexity: O(n)
    // Dynamic Programming (Kadane's algorithm)
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int max = nums[0], tmp = nums[0];

        for (int i = 1; i < nums.length; i++) {
            tmp = Math.max(nums[i], nums[i] + tmp);
            if (tmp > max)
                max = tmp;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        Solution solution = new Solution();
        int result = solution.maxSubArray(arr);

        System.out.println(result);
    }
}