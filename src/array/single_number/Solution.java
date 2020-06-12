package array.single_number;

public class Solution {
    /*
        If we take XOR of zero and some bit, it will return that bit a ^ 0 = a
        If we take XOR of two same bits, it will return 0, a ^ a = 0
     */
    // time complexity: O(n), space complexity: O(1)
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1};

        Solution solution = new Solution();
        int result = solution.singleNumber(nums);

        System.out.println(result);
    }
}
