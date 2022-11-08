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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // each time add up the number
        int carry = 0;
        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;
        
        // take the carry over number to next node
        while(l1 != null || l2 != null){
            int result = 0;
            if (l1 == null) {
                result = l2.val + carry;
            }
            else if (l2 == null){
                result = l1.val + carry;
            }
            else {
                result = l1.val + l2.val + carry;
            }
            int storeValue = result % 10;
            carry = result / 10;
            
            curr.next = new ListNode(storeValue);
            curr = curr.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        

        // if at the end of list, carry > 0, add 1 extra node at the end
        if (carry > 0) curr.next = new ListNode(carry);
        return dummyHead.next;
    }
}