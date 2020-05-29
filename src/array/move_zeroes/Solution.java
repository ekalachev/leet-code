package array.move_zeroes;

import java.util.Arrays;

public class Solution {
    // time complexity: O(n), space complexity: O(1)
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[index];
                nums[index] = nums[i];
                nums[i] = tmp;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};

        Solution solution = new Solution();
        solution.moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }
}
