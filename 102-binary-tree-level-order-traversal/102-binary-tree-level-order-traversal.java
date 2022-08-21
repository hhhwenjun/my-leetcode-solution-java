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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // level order traversal: BFS
        // 1. create the res list, create a queue
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;
        queue.add(root);
        int level = 0;
        // 2. use queue to store the root node, left, right
        while(!queue.isEmpty()){
            res.add(new ArrayList<Integer>());
            int levelLength = queue.size();
            
            for (int i = 0; i < levelLength; i++){
                // 3. poll from queue, put element to the list
                TreeNode curr = queue.poll();
                res.get(level).add(curr.val);
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            level++;
        }
        return res;
    }
}