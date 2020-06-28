package trees.symmetric_tree;

import trees.TreeNode;

public class Solution {
    // time complexity: O(n), space complexity: O(n)
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;
        if (left.val != right.val)
            return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public static void main(final String[] args) {
        /*
             1
            / \
           2   2
          / \ / \
         3  4 4  3
        */
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));

        Solution solution = new Solution();
        boolean isBST = solution.isSymmetric(root);         

        System.out.println("IsValidBST: " + isBST);
    }
}