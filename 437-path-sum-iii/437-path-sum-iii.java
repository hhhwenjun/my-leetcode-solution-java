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
    int target;
    int count = 0;
    
    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        fromRoot(root, 0); // from the root
        
        // treat every node as a root, start from the root again
        if (root != null && root.left != null) pathSum(root.left, targetSum);
        if (root != null && root.right != null) pathSum(root.right, targetSum);
        return count;
    }
    
    // calculate the sum from the root
    public void fromRoot(TreeNode root, long sum){
        if (root == null) return;
        sum += root.val;
        if (sum == target) count++;
        fromRoot(root.left, sum);
        fromRoot(root.right, sum);
    }
}