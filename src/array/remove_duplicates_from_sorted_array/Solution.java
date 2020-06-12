package array.remove_duplicates_from_sorted_array;

class Solution {
    // time complexity: O(n), space complexity: O(1)
    public int removeDuplicates(int[] nums) {
        int index = 0, n = nums.length;
        for(int i = 1; i < n; i++) {
            if(nums[index] != nums[i]) {
                index++;
                nums[index] = nums[i];
            }
        }

        return index + 1;
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