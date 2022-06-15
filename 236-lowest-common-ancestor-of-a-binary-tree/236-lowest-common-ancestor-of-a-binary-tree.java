/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
    * abstract: unique value, find p, q lowest common ancestor
    * use hashmap to find parent of all node
    * find all p's ancestors, check q all ancestor
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // stack for tree traversal
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        stack.add(root);
        
        while(!stack.isEmpty()){
            // get the current node
            TreeNode current = stack.pop();
            
            // keep traversing the tree
            if (current.left != null){
                parent.put(current.left, current);
                stack.add(current.left);
            }
            if (current.right != null){
                parent.put(current.right, current);
                stack.add(current.right);
            }
        }
        
        // find all p's ancestors
        Set<TreeNode> ancestor = new HashSet<>();
        while (p != null){
            ancestor.add(p);
            p = parent.get(p);
        }
        
        // check q all ancestor
        while (!ancestor.contains(q)){
            q = parent.get(q);
        }
        return q;
    }
}