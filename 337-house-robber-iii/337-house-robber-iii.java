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
    // decide if we want to rob this node
    public int[] robHelper(TreeNode root){
        // if null node
        if (root == null){
            return new int[]{0, 0};
        }
        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);
        // if we decide to rob this node
        int robThis = root.val + left[1] + right[1];
        // if we decide to rob this node's children
        int notRobThis = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{robThis, notRobThis};
    }
    public int rob(TreeNode root) {
        // for every node, if we rob this, cannot rob its children
        int[] res = robHelper(root);
        return Math.max(res[0], res[1]);
    }
}