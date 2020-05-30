package strings.first_unique_character_in_a_string;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // time complexity: O(n), space complexity: O(n)
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();

        for(int i = 0; i < length; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < length; i++) {
            if(map.get(s.charAt(i)) == 1)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";

        Solution solution = new Solution();
        int result = solution.firstUniqChar(s);

        System.out.println(result);
    }
}
