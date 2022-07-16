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
    public boolean isPalindrome(ListNode head) {
        if (head == null){
            return true;
        }
        // reverse the second half of the list
        ListNode firstHalfEnd = findSecondHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);
        
        // check if palindrome
        ListNode currFirst = head;
        ListNode currSecond = secondHalfStart;
        boolean isPalindrome = true;
        
        while(currSecond != null && isPalindrome){
            if (currFirst.val != currSecond.val){
                isPalindrome = false;
                break;
            }
            currFirst = currFirst.next;
            currSecond = currSecond.next;
        }
        return isPalindrome;
    }
    
    // reverse the linked list
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
    
    public ListNode findSecondHalf(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}