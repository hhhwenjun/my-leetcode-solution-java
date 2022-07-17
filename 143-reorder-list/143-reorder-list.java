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
    
    public void reorderList(ListNode head) {
        ListNode secondStart = findSecondHalf(head);
        ListNode firstStart = head;

        
        // reverse the second half
        secondStart = reverseList(secondStart);
        
        // each time take one node from 1st half list, and 2nd half list
        ListNode temp;
        while(secondStart.next != null){
            temp = firstStart.next;
            firstStart.next = secondStart;
            firstStart = temp;
            
            temp = secondStart.next;
            secondStart.next = firstStart;
            secondStart = temp;
        }
    }
    
    public ListNode findSecondHalf(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow in the middle, fast in the end
        return slow;
    }
    
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode tempNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNode;
        }
        return prev;
    }
}