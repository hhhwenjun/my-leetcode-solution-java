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
    public ListNode oddEvenList(ListNode head) {
        ListNode curr = head;
        
        // initialize two new linked list
        ListNode dummyOdd = new ListNode();
        ListNode dummyEven = new ListNode();
        ListNode currOdd = dummyOdd;
        ListNode currEven = dummyEven;
        
        // categorize the nodes to each linked list
        int i = 1;
        while(curr != null){
            if (i % 2 == 0){
                currEven.next = curr;
                currEven = currEven.next;
            }
            else {
                currOdd.next = curr;
                currOdd = currOdd.next;
            }
            curr = curr.next;
            i++;
        }
        
        // linked two lists
        currOdd.next = dummyEven.next;
        currEven.next = null;
        return dummyOdd.next;
    }
}