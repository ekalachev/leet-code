package dynamic_programming.climbing_stairs;

public class Solution {
    // time complexity: O(log n),  pow method takes n logn time.
    // space complexity: O(1)
    public int climbStairs(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) (fibn / sqrt5);
    }

    // time complexity: O(n), space complexity: O(1)
    public int climbStairs2(int n) {
        if (n <= 3)
            return n;

        int n1 = 1, n2 = 2, n3 = 0;

        for (int i = 3; i <= n; i++) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }

        return n3;
    }

    // time complexity: O(n), space complexity: O(n)
    // Dynamic programming
    public int climbStairs3(int n) {
        if (n <= 3)
            return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.climbStairs(7);
        int result2 = solution.climbStairs2(7);
        int result3 = solution.climbStairs3(7);

        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
    }
}