/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        if (headA == null || headB == null){
            return null;
        }
        ListNode currA = headA;
        while(currA != null){
            set.add(currA);
            currA = currA.next;
        }
        ListNode currB = headB;
        while(currB != null){
            if (set.contains(currB)){
                return currB;
            }
            currB = currB.next;
        }
        return null;
    }
}