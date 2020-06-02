package strings.strStr;

public class Solution {
    // time complexity: O(n - m), space complexity: O(1)
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if(n == 0 && m == 0) return 0;

        for(int i = 0; i < n - (m - 1); i++)
            if(haystack.substring(i, i + m).equals(needle))
                return i;

        return -1;
    }

    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";

        Solution solution = new Solution();
        int index = solution.strStr(haystack, needle);

        System.out.println(index);
    }
}
