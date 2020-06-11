package array.missingInteger;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // time complexity: O(n), space complexity: O(n)
    public int findMissingNum(int[] A) {
        Set<Integer> set = new HashSet<>();

        for (int num : A)
            set.add(num);

        int result = 1;

        while (set.contains(result))
            result++;

        return result;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 3, 6, 4, 1, 2};

        Solution solution = new Solution();
        int result = solution.findMissingNum(A);

        System.out.println(result);
    }
}
