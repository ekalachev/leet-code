package sorting_and_searching.merge_sorted_array;

import java.util.Arrays;

public class Solution {
    // time complexity: O(n + m), space complexity: O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = n + m - 1, i = m - 1, j = n - 1;
        while (j >= 0) {
            nums1[index--] = i < 0 || nums2[j] >= nums1[i]
                    ? nums2[j--]
                    : nums1[i--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;

        Solution solution = new Solution();
        solution.merge(nums1, m, nums2, n);

        System.out.println(String.join(",", Arrays.stream(nums1).mapToObj(String::valueOf).toArray(String[]::new)));
    }
}
