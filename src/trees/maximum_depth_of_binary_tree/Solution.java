package trees.maximum_depth_of_binary_tree;

import trees.TreeNode;

public class Solution {
    /*
        time complexity: O(n)
        space complexity: in the worst case, the tree is completely unbalanced,
                          e.g. each node has only left child node, the recursion call would
                          occur N times (the height of the tree), therefore the storage to keep the call stack
                          would be O(n). But in the best case (the tree is completely balanced), the height of
                          the tree would be O(log(n)).
                          Therefore, the space complexity in this case would be O(log(n))
    */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        //       3
        //      / \
        //     9  20
        //       /  \
        //      15   7

        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );

        Solution solution = new Solution();
        int maxDepth = solution.maxDepth(root);

        System.out.println(maxDepth);
    }
}
