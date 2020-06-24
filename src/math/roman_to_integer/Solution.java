package math.roman_to_integer;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static final Map<Character, Integer> nums = new HashMap<Character, Integer>(7) {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    // time complexity: O(n) where n = s.length(), space complexity: O(1)
    public int romanToInt(final String s) {
        int n = s.length();

        if (n == 0)
            return 0;

        int number = nums.get(s.charAt(n - 1));

        for (int i = n - 2; i >= 0; i--) {
            int prev = i + 1;
            while (i >= 0 && nums.get(s.charAt(i)) < nums.get(s.charAt(prev)))
                number -= nums.get(s.charAt(i--));

            if (i >= 0)
                number += nums.get(s.charAt(i));
        }

        return number;
    }

    public static void main(final String[] args) {
        String roman = "MCMXCIV";

        Solution solution = new Solution();
        int num = solution.romanToInt(roman);

        System.out.println(roman + " = " + num); // MCMXCIV = 1994
    }
}