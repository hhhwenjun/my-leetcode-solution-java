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
    Node[] visited = new Node[101];
    
    public Node cloneGraph(Node node) {
        // use visited array to represent if we visited it before, based on val
        // use dfs to traverse the curr node's neighbors
        if (node == null) return null;
        return dfs(node);
    }
    
    public Node dfs(Node node){
        if (visited[node.val] != null) return visited[node.val];
        // get the node's neighbor list
        visited[node.val] = new Node(node.val);
        List<Node> neighbors = node.neighbors;
        for (Node neighbor : neighbors){
            visited[node.val].neighbors.add(dfs(neighbor));
        }
        return visited[node.val];
    }
}