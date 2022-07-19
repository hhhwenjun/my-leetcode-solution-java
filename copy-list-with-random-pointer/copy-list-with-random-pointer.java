/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        // store original random index - new random node
        Map<Node, Node> randomMap = new HashMap<>();
        
        // 1. copy the linked list without random index
        // 2. loop through the list, check random index and get it from random map
        Node dummyHead = new Node(0);
        Node newCurr = dummyHead;
        Node curr = head;
        while(curr != null){
            newCurr.next = new Node(curr.val);
            newCurr = newCurr.next;
            randomMap.put(curr, newCurr);
            curr = curr.next;
        }
        curr = head;
        newCurr = dummyHead.next;
        
        // get it from random map and connect random node
        while(curr != null){
            if (curr.random != null) {
                newCurr.random = randomMap.get(curr.random);
            }
            newCurr = newCurr.next;
            curr = curr.next;
        }
        
        return dummyHead.next;
    }
}