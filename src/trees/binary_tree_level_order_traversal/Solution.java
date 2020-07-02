package trees.binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import trees.TreeNode;

public class Solution {
    // time complexity: O(n), space complexity: O(n)
    // Recursion
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, 0, result);
        return result;
    }

    private void helper(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null)
            return;
        if (level == result.size())
            result.add(new ArrayList<>());

        result.get(level).add(node.val);

        helper(node.left, level + 1, result);
        helper(node.right, level + 1, result);
    }

    // time complexity: O(n), space complexity: O(n)
    // Iteration
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;
        while (!queue.isEmpty()) {
            result.add(new ArrayList<>());
            int level_row = queue.size();

            for (int i = 0; i < level_row; i++) {
                TreeNode node = queue.remove();
                result.get(level).add(node.val);

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }

            level++;
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        Solution solution = new Solution();
        List<List<Integer>> result = solution.levelOrder(root);

        String resultStr = "[" + String.join(", ", result.stream()
                .map(x -> "\r\n\t["
                        + String.join(", ", x.stream().map(j -> String.valueOf(j)).collect(Collectors.toList())) + "]")
                .collect(Collectors.toList())) + "\r\n]";

        System.out.println(resultStr);
    }
}