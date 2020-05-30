package strings.reverse_string;

public class Solution {
    // time complexity: O(n) to swap N/2 element, space complexity: O(1)
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }

    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};

        Solution solution = new Solution();
        solution.reverseString(s);

        System.out.println(s);
    }
}
