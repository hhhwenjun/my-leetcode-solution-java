/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null) return head;
        
        Node dummyHead = new Node(0, null, head, null);
        flatten(dummyHead, head);
        dummyHead.next.prev = null;
        return dummyHead.next;
    }
    
    // recursion method
    public Node flatten(Node prev, Node curr){
        // actually prev is prev, curr is prev's child
        // connect child and prev as 'next'
        if (curr == null) return prev;
        prev.next = curr;
        curr.prev = prev;
        
        // check if it has child, if so, continue to connect child as next
        Node tempNext = curr.next;
        Node temp = flatten(curr, curr.child);
        curr.child = null;
        
        return flatten(temp, tempNext);
    }
}