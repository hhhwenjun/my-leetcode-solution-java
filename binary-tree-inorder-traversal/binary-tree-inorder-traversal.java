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
    public List<Integer> inorderTraversal(TreeNode root) {
        // in-order traversal: recursion
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        inorder(root, res);
        return res;
    }
    
    public void inorder(TreeNode root, List<Integer> res){
        if (root == null) return;
        // inorder traversal part, go to left
        inorder(root.left, res);
        // middle
        res.add(root.val);
        // go to right
        inorder(root.right, res);
    }
}