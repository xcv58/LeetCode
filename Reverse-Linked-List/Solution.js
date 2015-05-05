/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function(head) {
    var newHead = null;
    while (head !== null) {
        var tmpNode = head.next;
        head.next = newHead;
        newHead = head;
        head = tmpNode;
    }
    return newHead;
};
