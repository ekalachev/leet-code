package array.rotate_array;

public class Solution {
    // time complexity: O(n), space complexity: O(1)
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k == 0) return;

        k = k % nums.length;
        int counter = 0;
        for (int startIndex = 0; counter < nums.length; startIndex++) {
            int currentIndex = startIndex;
            int prevNum = nums[startIndex];

            do {
                int nextIndex = (currentIndex + k) % nums.length;
                int tmp = nums[nextIndex];
                nums[nextIndex] = prevNum;
                prevNum = tmp;
                currentIndex = nextIndex;

                counter++;
            } while (currentIndex != startIndex);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,3,4};

        solution.rotate(nums, 2);

        for (int num : nums) {
            System.out.println(num);
        }
    }
}
