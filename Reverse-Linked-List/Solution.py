# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param {ListNode} head
    # @return {ListNode}
    def reverseList(self, head):
        new_head = None
        while head is not None:
            tmp_node = head.next
            head.next = new_head
            new_head = head
            head = tmp_node
        return new_head
