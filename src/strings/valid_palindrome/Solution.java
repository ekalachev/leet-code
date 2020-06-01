package strings.valid_palindrome;

public class Solution {
    // time complexity: O(n), space complexity: O(1)
    public boolean isPalindrome(String s) {
        if(s.isEmpty())  return true;

        int n = s.length();
        for(int left = 0, right = n - 1; left < right; left++, right--){
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";

        Solution solution = new Solution();
        boolean isPalindrome = solution.isPalindrome(str);

        System.out.println(isPalindrome);
    }
}
