# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val)
#         @val = val
#         @next = nil
#     end
# end

# @param {ListNode} head
# @return {ListNode}
def reverse_list(head)
    newHead = nil
    while !head.nil?
        tmpNode = head.next
        head.next = newHead
        newHead = head
        head = tmpNode
    end
    return newHead
end
