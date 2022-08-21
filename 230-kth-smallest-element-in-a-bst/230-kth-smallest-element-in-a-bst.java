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
    public int kthSmallest(TreeNode root, int k) {
        // 1. traverse the tree and put values in a list
        List<Integer> treeList = new ArrayList<>();
        
        inorder(root, treeList);
        // 2. sort the list
        Collections.sort(treeList);
        // 3. get the corresponding value in kth location
        return treeList.get(k - 1);
        
    }
    
    public void inorder(TreeNode root, List<Integer> treeList){
        if (root == null) return;
        inorder(root.left, treeList);
        treeList.add(root.val);
        inorder(root.right, treeList);
    }
}