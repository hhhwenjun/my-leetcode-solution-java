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
    
    public ListNode rotateRight(ListNode head, int k) {
        // 1. find true k : k % length of list, a loop to find length of list
        if (head == null || head.next == null || k == 0) return head;
        
        ListNode curr = head;
        int length = 0;
        while (curr != null){
            length++;
            curr = curr.next;
        }
        int trueK = k % length;
        
        if (trueK == 0) return head;
        
        // 2. two pointers: slow, fast, fast go to the end of list, slow k steps away from fast
        ListNode slow = head;
        ListNode fast = head;
        int loc = 0;
        while(loc != trueK){
            loc++;
            fast = fast.next;
        }
        
        // find the break point
        while(fast != null && fast.next != null){
            fast = fast.next;
            slow = slow.next; // stop at 3
        }
        
        // 3. slow pointer 1, 2, 3 || 4, 5, then move the back of list to the front, make a new head
        ListNode newHead = slow.next;
        fast.next = head;
        slow.next = null;
            
        // 4. return the new head, such as 4 in last cases
        return newHead;
    }
}