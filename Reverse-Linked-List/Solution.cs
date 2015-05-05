/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode tmpNode = head.next;
            head.next = newHead;
            newHead = head;
            head = tmpNode;
        }
        return newHead;
    }
}
