package math.power_of_three;

public class Solution {
    // n is a power of three if and only if i is an integer. In Java, we check if a number is an integer by taking the decimal part (using % 1) and checking if it is 0.
    public boolean isPowerOfThree(int n) {
        if(n < 1) return false;
        
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    public static void main(final String[] args) {

        Solution solution = new Solution();
        boolean result = solution.isPowerOfThree(27);

        System.out.println("Result is: " + result);
    }
}