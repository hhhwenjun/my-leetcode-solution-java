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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // two pointers: fast pointer, slow pointer
        ListNode dummyHead = new ListNode();
        int distance = n;
        dummyHead.next = head;
        
        ListNode fast = dummyHead;
        for (int i = 0; i < distance; i++){
            fast = fast.next;
        }
        ListNode slow = dummyHead;
        
        // when fast pointer go to the end of linkedlist, 
        // slow pointer in the node before target
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        // remove the nth node from the end
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}