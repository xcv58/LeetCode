public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        for (ListNode anchor = head, base = head; anchor != null && base != null; anchor = anchor.next) {
            if (base.val == anchor.val) {
                base.next = anchor.next;
            } else {
                base = anchor;
            }
        }
        return head;
    }
}
