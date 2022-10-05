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
        if (root == null) return res;
        backtracking(root, new ArrayList<Integer>(), targetSum);
        return res;
    }
    
    // use backtracking method to find the route and put in the list
    public void backtracking(TreeNode root, List<Integer> subset, int sum){
        if (root == null) return;
        
        subset.add(root.val);
        if (sum == root.val && root.left == null && root.right == null){
            res.add(new ArrayList(subset));
        }
        else {
            backtracking(root.left, subset, sum - root.val);
            backtracking(root.right, subset, sum - root.val);
        }
        subset.remove(subset.size() - 1);
        sum += root.val;
    }
}