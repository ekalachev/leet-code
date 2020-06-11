package array.split_array_into_two_parts;

public class Solution {

    public int splitIntoTwoParts(int X, int[] A) {
        int n = A.length;
        int green = 0, red = 0, i = 0, j = n - 1;
        while (i <= j) {
            if (A[i] == X) {
                green++;
                i++;
            }
            if (A[j] != X) {
                red++;
                j--;
            }

            while (green != red && i < j) {
                if (green < red) {
                    if (A[i] == X)
                        green++;
                    i++;
                } else {
                    if (A[j] != X)
                        red++;
                    j--;
                }
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int[] A = new int[]{5, 5, 1, 7, 3, 3, 5};
        //int[] A = new int[]{5,5,5,5,5,5,1};

        Solution solution2 = new Solution();
        int result = solution2.splitIntoTwoParts(5, A);

        System.out.println(result);
    }
}
