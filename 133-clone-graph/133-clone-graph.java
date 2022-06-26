/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    // use hashmap to track visited, since we do not know how many nodes
    private Map<Node, Node> visited = new HashMap<>();
        
    // use the dfs to traverse the node and neighbor lists + recursion
    public Node cloneGraph(Node node) {
        // consider the null case
        if (node == null){
            return node;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        visited.put(node, new Node(node.val, new ArrayList<Node>()));
        
        while (!stack.isEmpty()){
            Node current = stack.pop();
            
            for (Node neighbor : current.neighbors){
                if (!visited.containsKey(neighbor)){
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<Node>()));
                    stack.add(neighbor);
                }
                // add the clone of the neighbor
                visited.get(current).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
}