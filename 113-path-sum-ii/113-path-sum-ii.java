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
    List<List<Integer>> res;  
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {    
        res = new ArrayList<>();
        if (root == null){
            return res;
        }
        
        backtracking(root, new ArrayList<>(), targetSum);
        return res;
    }
    
    // backtracking to traverse the tree and find all solutions
    public void backtracking(TreeNode root, List<Integer> subset, int numLeft){
        if (root == null){
            return;
        }
        subset.add(root.val);
        
        if (root.val == numLeft && root.left == null && root.right == null){
            res.add(new ArrayList(subset));
            //return;
        }
        else {
            backtracking(root.left, subset, numLeft - root.val);
            backtracking(root.right, subset, numLeft - root.val);
        }
        // backtracking process
        // subset.add(root.val);
        
        subset.remove(subset.size() - 1);
        numLeft += root.val;
    }
}