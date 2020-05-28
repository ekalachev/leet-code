package array.intersection_of_two_arrays_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    // time complexity: O(n), space complexity: O(n)
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        List<Integer> result = new ArrayList<>();

        for (int num : nums2) {
            if (map.containsKey(num)) {
                int stored = map.get(num);
                if (stored == 1)
                    map.remove(num);
                else
                    map.put(num, stored - 1);

                result.add(num);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};

        int[] result = solution.intersect(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
