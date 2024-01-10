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
    private int result;
    public int amountOfTime(TreeNode root, int start) {
        DFS(root, start);
        return result;
    }

    private int DFS(TreeNode node, int start) {
        if (node == null) return 0;

        int leftNode = DFS(node.left, start);
        int rightNode = DFS(node.right, start);

        if (node.val == start) {
            result = Math.max(leftNode, rightNode);
            return -1;
        }

        else if (0 <= leftNode && 0 <= rightNode) {
            return Math.max(leftNode, rightNode) + 1;
        }

        result = Math.max(result, Math.abs(leftNode - rightNode));
        return Math.min(leftNode, rightNode) - 1;
    }
}