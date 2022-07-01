/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Pair {
    private Node node;
    private int level;
    
    public Pair(Node node, int level){
        this.node = node;
        this.level = level;
    }
    
    public int getLevel(){
        return level;
    }
    
    public Node getNode(){
        return node;
    }
}

class Solution {
    // bfs: put nodes to a queue
    public List<List<Integer>> levelOrder(Node root) {
        // use hashmap to store level and list of nodes in that level
        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        Queue<Pair> queue = new LinkedList<Pair>();
        List<List<Integer>> res = new ArrayList<>();
        
        // if null cases
        if (root == null){
            return res;
        }
        
        // each time poll a node from queue and store the children, level + 1
        queue.add(new Pair(root, 0));
        
        while (!queue.isEmpty()){
            Pair current = queue.poll();
            int level = current.getLevel();
            Node node = current.getNode();
            
            if (!levelMap.containsKey(level)){
                levelMap.put(level, new ArrayList());
            }
            levelMap.get(level).add(node.val);
            
            for (Node child : node.children){
                // put each node to the queue
                queue.add(new Pair(child, level + 1));
            }
        }
        
        // loop through the hashmap and store to result list
        for (Map.Entry<Integer,List<Integer>> levelNodes : levelMap.entrySet()){
            res.add(levelNodes.getValue());
        }
        return res;
    }
}