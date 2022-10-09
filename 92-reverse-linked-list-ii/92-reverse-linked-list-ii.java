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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // corner case
        if (head == null || head.next == null || left <= 0 || right <= 0 || left == right){
            return head;
        }
        // dummy head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        // locate the left node
        for (int i = 0; i <= left - 2; i++){
            prev = prev.next;
        }
        
        // reverse the list from left to right
        ListNode curr = prev.next;
        ListNode temp = null;
        ListNode reverseHead = null;
        
        // reverse the part between
        for (int i = 0; i <= right - left; i++){
            temp = curr.next;
            curr.next = reverseHead;
            reverseHead = curr;
            curr = temp;
        }
        
        // connect the reversed list with prev node
        prev.next.next = curr;
        prev.next = reverseHead;
        
        return dummy.next;
    }
}