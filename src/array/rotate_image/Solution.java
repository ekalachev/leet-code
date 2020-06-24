package array.rotate_image;

public class Solution {
    // time complexity: O(n^2), space complexity: O(1)
    public void rotate(final int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n / 2 + n % 2; i++) {
            for (int j = i; j < n - i - 1; j++) {

                int i1 = i, j1 = j;
                int i2 = j, j2 = n - i - 1;
                int i3 = n - i - 1, j3 = n - j - 1;
                int i4 = n - j - 1, j4 = i;

                int tmp = matrix[i2][j2];
                matrix[i2][j2] = matrix[i1][j1];

                int tmp2 = matrix[i3][j3];
                matrix[i3][j3] = tmp;

                tmp = matrix[i4][j4];
                matrix[i4][j4] = tmp2;

                matrix[i1][j1] = tmp;
            }
        }
    }

    public static void main(final String[] args) {
        final int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        final Solution solution = new Solution();
        solution.rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}