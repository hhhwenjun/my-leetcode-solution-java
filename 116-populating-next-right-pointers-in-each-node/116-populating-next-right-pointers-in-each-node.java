/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        else {
            helper(root);
            connect(root.left);
        }
        return root;
    }
    
    public Node helper(Node root){
        // bfs: connect node to the next
        if (root == null){
            return root;
        }
        if (root.left != null && root.right != null){
            root.left.next = root.right;
        }
        if (root.next != null && root.right != null){
            root.right.next = root.next.left;
        }
        return helper(root.next);
    }
}