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
    int count = 0;
    int k = 0;
    HashMap<Long, Integer> h = new HashMap<>();
    
    public int pathSum(TreeNode root, int targetSum) {
        k = targetSum;
        preorder(root, 0L);
        return count;
    }
    
    public void preorder(TreeNode node, long currSum){
        if (node == null) return;
        
        // current prefix sum
        currSum += node.val;
        // here is the sum we're looking for
        if (currSum == k){
            count++;
        }
        
        // number of times the currSum - k has occured already
        count += h.getOrDefault(currSum - k, 0);
        
        // add the current sum into hashmap
        h.put(currSum, h.getOrDefault(currSum, 0) + 1);
        
        // process left subtree
        preorder(node.left, currSum);
        // process right subtree
        preorder(node.right, currSum);
        
        // remove the current sum from hashmap
        // in order not to use it during parallel subtree processing
        h.put(currSum, h.get(currSum) - 1);
    }
}