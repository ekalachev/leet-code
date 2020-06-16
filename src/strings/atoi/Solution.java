package strings.atoi;

public class Solution {
    // time complexity: O(n), space complexity: O(1)
    public int myAtoi(String str) {
        int result = 0, index = 0, n = str.length();
        if (n == 0)
            return 0;

        while (index < n && str.charAt(index) == ' ')
            index++;

        if (index == n || !Character.isDigit(str.charAt(index)) && str.charAt(index) != '-' && str.charAt(index) != '+')
            return 0;

        int sign = str.charAt(index) == '-' ? -1 : 1;

        if (!Character.isDigit(str.charAt(index)))
            index++;

        while (index < n && Character.isDigit(str.charAt(index))) {

            int digit = Character.getNumericValue(str.charAt(index++)) * sign;

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7))
                return Integer.MAX_VALUE;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && digit < -8))
                return Integer.MIN_VALUE;

            result = result * 10 + digit;
        }

        return result;
    }

    public static void main(String[] args) {
        String str = "   -42";

        Solution solution = new Solution();
        int result = solution.myAtoi(str);

        System.out.println(result);
    }
}