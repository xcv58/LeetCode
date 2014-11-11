public class Solution {
    public ListNode sortList(ListNode head) {
        int len = 0;
        int section = 1;

        ListNode anchor = head;
        ListNode parent = new ListNode(0);
        ListNode superHead = parent;
        parent.next = head;

        while (true) {
            if (anchor == null) {
                section *= 2;
                if (section > len) {
                    break;
                }
                parent = superHead;
                anchor = parent.next;
                continue;
            }

            ListNode h1 = anchor;
            ListNode h2 = this.cut(anchor, section);
            anchor = this.cut(h2, section);
            parent = this.combineSortedList(parent, h1, h2);
            len += section == 1 ? 2 : 0;
        }

        return superHead.next;
    }

    private ListNode cut(ListNode head, int len) {
        for (; len > 1 && head != null; len--, head = head.next);
        if (head == null) {
            return null;
        }
        ListNode nextHead = head.next;
        head.next = null;
        return nextHead;
    }

    public ListNode combineSortedList(ListNode parent, ListNode h1, ListNode h2) {
        while (h1 != null && h2 != null) {
            parent.next = h1.val < h2.val ? h1 : h2;
            parent = parent.next;
            if (h1.val < h2.val) {
                h1 = h1.next;
            } else {
                h2 = h2.next;
            }
        }
        for (parent.next = h1 != null ? h1 : h2; parent.next != null; parent = parent.next);
        return parent;
    }
}
