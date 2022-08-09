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
    public ListNode deleteDuplicates(ListNode head) {
        // use a hashset to store the values, if contains, it is duplicate
        Set<Integer> nodeValues = new HashSet<>();
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        
        ListNode curr = head;
        ListNode prev = dummyHead;
        while(curr != null){
            if (nodeValues.contains(curr.val)){
                prev.next = curr.next;
                curr = curr.next;
                continue;
            }
            nodeValues.add(curr.val);
            curr = curr.next;
            prev = prev.next;
        }
        return dummyHead.next;
    }
}