public class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        for (ListNode n1 = head, n2 = head; n2 != null; n1 = n1.next, n2 = n2.next) {
            if (n2 == null || n2.next == null) {
                return false;
            }
            n2 = n2.next;
            if (n1 == n2) {
                return true;
            }
        }
        return false;
    }

}
