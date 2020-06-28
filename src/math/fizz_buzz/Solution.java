package math.fizz_buzz;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // time complexity: O(n).
    // Space complexity: O(1) - Since it's just the answer array to be returned, it won't be part of the algorithms complexity.
    // And there is no intermediate space utilization. Hence O(1).
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0)
                result.add("FizzBuzz");
            else if (i % 3 == 0)
                result.add("Fizz");
            else if (i % 5 == 0)
                result.add("Buzz");
            else
                result.add(Integer.toString(i));
        }

        return result;
    }

    public static void main(final String[] args) {
        int n = 15;
        Solution solution = new Solution();
        List<String> result = solution.fizzBuzz(n);

        for(int i = 0; i < n; i++) {
            System.out.println(result.get(i));
        }
    }
}