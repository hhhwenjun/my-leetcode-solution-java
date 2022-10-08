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
    public ListNode mergeKLists(ListNode[] lists) {
        // each time compare the listnode pointer
        // find the max length of the new list
        int length = 0;
        for (ListNode list : lists){
            ListNode curr = list;
            while(curr != null){
                curr = curr.next;
                length++;
            }
        }
        int currListLength = 0;
        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;
        while(currListLength < length){
            int min = Integer.MAX_VALUE;
            ListNode minNode = new ListNode();
            int minIndex = 0;
            for (int i = 0; i < lists.length; i++){
                if (lists[i] != null && lists[i].val < min){
                    min = lists[i].val;
                    minNode = lists[i];
                    minIndex = i;
                }
            }
            curr.next = minNode;
            curr = curr.next;
            currListLength++;
            if (lists[minIndex] != null) lists[minIndex] = lists[minIndex].next;
        }
        return dummyHead.next;
    }
}