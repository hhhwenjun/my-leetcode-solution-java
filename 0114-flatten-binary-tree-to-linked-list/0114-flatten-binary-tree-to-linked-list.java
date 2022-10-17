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
    Queue<TreeNode> temp = new LinkedList<>();
    
    public void flatten(TreeNode root) {
        if (root == null) return;
        preorder(root);
        root.left = null;
        root.right = null;
        TreeNode prev = root;
        while(!temp.isEmpty()){
            TreeNode curr = temp.poll();
            if (curr == root) {
                continue;
            }
            prev.left = null;
            prev.right = curr;
            prev = curr;
        }
    }
    
    public void preorder(TreeNode root){
        if (root == null){
            return;
        }
        temp.add(root);
        preorder(root.left);
        preorder(root.right);
    }
}