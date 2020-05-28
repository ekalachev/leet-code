package array.single_number;

import java.util.HashSet;

public class Solution {
    // time complexity: O(n), space complexity: O(n)
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num))
                set.remove(num);
            else
                set.add(num);
        }

        return set.stream().findFirst().get();
    }

    // time complexity: O(n), space complexity: O(1)
    public int singleNumber2(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 2, 1};

        int result = solution.singleNumber(nums);
        System.out.println(result);

        int result2 = solution.singleNumber(nums);
        System.out.println(result2);
    }
}
