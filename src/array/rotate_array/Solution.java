package array.rotate_array;

public class Solution {

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
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};

        solution.rotate(nums, 4);

        for (int num : nums) {
            System.out.println(num);
        }
    }
}
