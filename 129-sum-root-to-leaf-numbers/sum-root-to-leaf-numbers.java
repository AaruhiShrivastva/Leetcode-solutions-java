/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }

        // Calculate the number represented by the path up to the current node
        currentSum = currentSum * 10 + node.val;

        // If it's a leaf node, return the formed path number
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        // Recursively calculate the sum for left and right subtrees
        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }
}