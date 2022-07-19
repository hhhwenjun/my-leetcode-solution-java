/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    // find the smallest node, then use prev and curr to go through the list
    // each time compare with the curr and prev value, insert to list
    public Node insert(Node head, int insertVal) {
        
        // edge case
        if (head == null){
            Node newHead = new Node(insertVal);
            newHead.next = newHead;
            return newHead;
        }
        // find smallest
        Node currSmall = head.next;
        Node smallest = currSmall; 
        Node prevSmall = head;
        Node prevSmallest = prevSmall;
        int smallestVal = currSmall.val;
        boolean indicator = true;
        while(indicator || prevSmall != head){
            indicator = false;
            if (currSmall.val <= smallest.val && prevSmall.val != currSmall.val){
                smallest = currSmall;
                smallestVal = smallest.val;
                prevSmallest = prevSmall;
            }
            currSmall = currSmall.next;
            prevSmall = prevSmall.next;
        }
        
        // start from smallest node and find the location
        Node curr = smallest;
        Node prev = prevSmallest;
        
        if (insertVal < curr.val){
            Node newNode = new Node(insertVal);
            newNode.next = curr;
            prev.next = newNode;
            return head;
        }
        // if insertVal should be after the smallest node
        prev = curr;
        curr = curr.next;
        while(curr != smallest){
            if (insertVal <= curr.val && insertVal > prev.val){
                Node newNode = new Node(insertVal);
                newNode.next = curr;
                prev.next = newNode;
                return head;
            }
            curr = curr.next;
            prev = prev.next;
        }
        // otherwise it should be the largest node
        // before the smallest node
        Node newNode = new Node(insertVal);
        newNode.next = smallest;
        prevSmallest.next = newNode;
        return head;
    }
}