package strings.longest_common_prefix;

public class Solution {
    // time complexity: O(S) where S is the sum of all characters in all strings, space complexity: O(1)
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return prefix;
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};

        Solution solution = new Solution();
        String prefix = solution.longestCommonPrefix(strs);

        System.out.println(prefix);
    }
}
