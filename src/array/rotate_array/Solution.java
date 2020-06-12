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

    /*
        This approach is based on the fact that when we rotate the array k times, k elements from the back
        end of the array come to the front and the rest of the elements from the front shift backwards.

        In this approach, we firstly reverse all the elements of the array. Then, reversing the first k elements
        followed by reversing the rest n-k elements gives us the required result.
     */
    // time complexity: O(n), space complexity: O(1)
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};

        Solution solution = new Solution();
        solution.rotate2(nums, 3);

        for (int num : nums) {
            System.out.println(num);
        }
    }
}
