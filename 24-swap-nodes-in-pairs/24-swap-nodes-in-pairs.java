/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        return swap(head);
    }
    
    // recursion method to swap the nodes
    public ListNode swap(ListNode curr){
        // base case
        if (curr == null) return null;
        if (curr.next == null) return curr;
        
        // swap the nodes
        ListNode nextNode = curr.next;
        curr.next = nextNode.next;
        nextNode.next = curr;
        curr.next = swap(nextNode.next.next);
        return nextNode;
    }
}