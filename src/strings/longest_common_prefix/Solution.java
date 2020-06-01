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

    // time complexity: O(S) where S is the sum of all characters in all strings, space complexity: O(1)
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String res = strs[0];
        for (String str : strs) {
            while (!str.startsWith(res)) {
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
    }

    // time complexity: O(S) where S is the sum of all characters in all strings, space complexity: O(1)
    public String longestCommonPrefix3(String[] strs) {
        if (strs.length == 0 || strs[0].length() == 0) return "";
        int index = 0;
        do {
            char c = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() <= index || c != strs[i].charAt(index))
                    return strs[0].substring(0, index);
            }
            index++;
        } while (strs[0].length() > index);
        return strs[0].substring(0, index);
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};

        Solution solution = new Solution();

        String prefix = solution.longestCommonPrefix(strs);
        System.out.println(prefix);

        prefix = solution.longestCommonPrefix2(strs);
        System.out.println(prefix);

        prefix = solution.longestCommonPrefix3(strs);
        System.out.println(prefix);
    }
}
