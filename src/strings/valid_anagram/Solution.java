
package strings.valid_anagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    // time complexity: O(s log s), space complexity: O(1) (only for unicode characters)
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int n = s.length();
        int[] letters = new int[26];

        for (int i = 0; i < n; i++)
            letters[s.charAt(i) - 'a']++;

        for (int i = 0; i < n; i++) {
            int index = t.charAt(i) - 'a';
            letters[index]--;
            if (letters[index] < 0) return false;
        }

        return true;
    }

    // time complexity: O(s), space complexity: O(s)
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;

        int n = s.length();
        Map<Character, Integer> map = new HashMap<>(n);

        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (char c : t.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            if (count == 0)
                return false;
            else
                map.put(c, count - 1);
        }

        return true;
    }

    // time complexity: O(s log s), space complexity: O(s)
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";

        Solution solution = new Solution();
        boolean isAnagram = solution.isAnagram(s, t);
        System.out.println(isAnagram);

        isAnagram = solution.isAnagram2(s, t);
        System.out.println(isAnagram);

        isAnagram = solution.isAnagram3(s, t);
        System.out.println(isAnagram);
    }
}