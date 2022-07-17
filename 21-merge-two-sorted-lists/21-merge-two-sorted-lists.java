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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // create a new list to store the merged list
        ListNode dummyHead = new ListNode();
        ListNode currMerged = dummyHead;
        
        // each time we compare the curr node of two lists,
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        
        // traverse the two list
        // put the smaller to the new list, until we traverse all the nodes
        while(curr1 != null && curr2 != null){
            if (curr1.val <= curr2.val){
                currMerged.next = curr1;
                currMerged = currMerged.next;
                curr1 = curr1.next;
            }
            else {
                currMerged.next = curr2;
                currMerged = currMerged.next;
                curr2 = curr2.next;
            }
        }
        
        // traverse the rest of the longer list
        if (curr1 == null){
            // to the list2
            while(curr2 != null){
                currMerged.next = curr2;
                currMerged = currMerged.next;
                curr2 = curr2.next;
            }
        }
        else {
            // to the list1
            while(curr1 != null){
                currMerged.next = curr1;
                currMerged = currMerged.next;
                curr1 = curr1.next;
            }
        }
        return dummyHead.next;
    }
}