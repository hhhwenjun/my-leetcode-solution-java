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
    /**
    * abstract; traverse the tree return vertical order
    * in-order traversal? (similiar pattern)
    * leftchild - right = rightchild - left
    */
    List<List<Integer>> res;
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        res = new ArrayList<>();
        if (root == null){
            return res;
        }
        // vertical column map and array list
        Map<Integer, ArrayList> columnTable = new HashMap<>();
        // record the treenode and its column number
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        int column = 0;
        queue.add(new Pair(root, column));
        int minColumn = 0, maxColumn = 0;
        
        // traverse all the nodes
        while (!queue.isEmpty()){
            Pair<TreeNode, Integer> pair = queue.poll();
            root = pair.getKey();
            column = pair.getValue();
            
            if (root != null){
                if (!columnTable.containsKey(column)){
                    columnTable.put(column, new ArrayList<Integer>());
                }
                columnTable.get(column).add(root.val);
                minColumn = Math.min(minColumn, column);
                maxColumn = Math.max(maxColumn, column);
                
                queue.add(new Pair(root.left, column - 1));
                queue.add(new Pair(root.right, column + 1));
            }
        }
        for (int i = minColumn; i <= maxColumn; i++){
            res.add(columnTable.get(i));
        }
        return res;
    }
}