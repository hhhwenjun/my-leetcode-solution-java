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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null || (head.next == null && head.val == val)){
            return null;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode curr = dummyHead.next;
        
        while(curr != null){
            if (curr.val == val){
                prev.next = curr.next;
                curr = curr.next;
                continue;
            }
            curr = curr.next;
            prev = prev.next;
        }
        return dummyHead.next;
    }
}