# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param head, a ListNode
    # @return a ListNode
    def sortList(self, head):
        len = 0
        section = 1

        anchor = head
        parent = ListNode(0)
        superHead = parent
        parent.next = head

        while True:
            if anchor is None:
                section *= 2
                if section > len:
                    break
                parent = superHead
                anchor = parent.next
                continue
            h1 = anchor
            h2 = self.cut(anchor, section)
            anchor = self.cut(h2, section)
            parent = self.combineSortedList(parent, h1, h2)
            len += 2 if section == 1 else 0

        return superHead.next

    def cut(self, head, len):
        while len > 1 and head is not None:
            len -= 1
            head = head.next
        if head is None:
            return None
        nextHead = head.next
        head.next = None
        return nextHead

    def combineSortedList(self, parent, h1, h2):
        while h1 is not None and h2 is not None:
            parent.next = h1 if h1.val < h2.val else h2
            parent = parent.next
            if h1.val < h2.val:
                h1 = h1.next
            else:
                h2 = h2.next
        parent.next = h1 if h1 is not None else h2
        while parent.next is not None:
            parent = parent.next
        return parent;
