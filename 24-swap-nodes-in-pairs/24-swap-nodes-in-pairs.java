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
        // dummy node acts as the prevNode for the head node
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prevNode = dummy;
        while((head != null) && (head.next != null)){
            // nodes to be swapped
            ListNode firstNode = head;
            ListNode secondNode = head.next;
            
            // swapping
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            
            // reinitializing the head and prev for next swap
            prevNode = firstNode;
            head = firstNode.next;
        }
        return dummy.next;
    }
}