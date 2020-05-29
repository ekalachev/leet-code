package array.intersection_of_two_arrays_2;

import java.util.*;

public class Solution {
    // time complexity: O(n + m), space complexity: O((n < m ? n : m) + (n < m ? n : m))
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] smaller = nums1.length >= nums2.length ? nums2 : nums1;
        int[] bigger = nums1.length < nums2.length ? nums2 : nums1;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : smaller)
            map.put(num, map.getOrDefault(num, 0) + 1);

        Queue<Integer> queue = new LinkedList<>();
        for (int num : bigger)
            if (map.containsKey(num) && map.get(num) > 0) {
                queue.add(num);
                map.put(num, map.get(num) - 1);
            }

        int[] result = new int[queue.size()];
        int i = 0;
        while (!queue.isEmpty())
            result[i++] = queue.poll();

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};

        int[] result = solution.intersect(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
