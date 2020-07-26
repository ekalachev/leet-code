package others.number_of_1_bits;

public class Solution {
    // time complexity: O(1), space complexity: O(1)
    public int hammingWeight(int n) {
        int result = 0;
        
        // The key idea here is to realize that for any number n,
        // doing a bit-wise AND of n and n - 1 flips the least-significant 1-bit in n to 0.
        while(n != 0) {
            result++;
            n = n & (n - 1);
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.hammingWeight(10);

        System.out.println(result);
    }
}