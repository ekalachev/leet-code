package trees.validate_binary_search_tree;

import trees.TreeNode;

public class Solution {
    // time complexity: O(n) since we visit each node exactly once
    // space complexity: O(n) since we keep up to the entire tree
    public boolean isValidBST(final TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(final TreeNode root, final Integer min, final Integer max) {
        if (root == null)
            return true;
        if ((min != null && root.val <= min) || (max != null && root.val >= max))
            return false;

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    public static void main(final String[] args) {
        /*
             5
            / \
           1   4
              /  \
             3    6
        */
        TreeNode root = new TreeNode(5, new TreeNode(1, null, null), new TreeNode(4, new TreeNode(3), new TreeNode(6)));

        Solution solution = new Solution();
        boolean isBST = solution.isValidBST(root);         

        System.out.println("IsValidBST: " + isBST);
    }
}