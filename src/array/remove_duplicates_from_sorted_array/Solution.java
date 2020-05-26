package array.remove_duplicates_from_sorted_array;

class Solution {
    // time complexity: O(n), space complexity: O(1)
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int currentPosition = 1;
        int prev = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (prev != nums[i]) {
                nums[currentPosition] = nums[i];

                currentPosition++;
                prev = nums[i];
            }
        }

        return currentPosition;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int len = solution.removeDuplicates(nums);

        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}