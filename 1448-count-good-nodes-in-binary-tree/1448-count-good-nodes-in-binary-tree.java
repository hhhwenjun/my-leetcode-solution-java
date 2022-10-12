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
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        int count = 1;
        TreeNode prev = root;
        return 1 + findGood(root.left, prev) + findGood(root.right, prev);
    }
    
    public int findGood(TreeNode curr, TreeNode prev){
        if (curr == null) return 0;
        int count = 0;
        if (curr.val >= prev.val){
            prev = curr;
            count++;
        }
        return count + findGood(curr.left, prev) + findGood(curr.right, prev);
    }
}