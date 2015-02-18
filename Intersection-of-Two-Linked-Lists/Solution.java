public class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB, lastA = a, lastB = b;
        for (; a != null && b != null; lastA = a, lastB = b, a = a.next, b = b.next);
        for (; b != null; lastB = b, b = b.next, headB = headB.next);
        for (; a != null; lastA = a, a = a.next, headA = headA.next);
        for (; headA != null && headB != null && headA != headB; headA = headA.next, headB = headB.next);
        return (lastA != lastB) ? null :headA;
    }
}
