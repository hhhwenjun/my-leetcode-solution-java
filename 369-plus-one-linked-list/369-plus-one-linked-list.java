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
    // 1. reverse the list 
    // 2. add 1 and bring over carry
    // 3. reverse the lsit
    public ListNode plusOne(ListNode head) {
        head = reverse(head);
        ListNode curr = head;
        int carry = 1;
        if (curr.val + carry >= 10){
            while(curr != null && curr.val + carry >= 10){
                int value = curr.val + carry;
                curr.val = 0;
                curr = curr.next;
            }
            if (curr == null) {
                curr = head;
                while(curr.next != null) curr = curr.next;
                ListNode last = new ListNode(1);
                curr.next = last;
            }
            else {
                curr.val += 1;
            }
        }
        else {
            curr.val += 1;
        }
        head = reverse(head);
        return head;
    }
    
    public ListNode reverse(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode prev = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return prev;
    }
}