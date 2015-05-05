#include <stdlib.h>

struct ListNode {
    int val;
    struct ListNode *next;
};

struct ListNode* reverseList(struct ListNode* head) {
    struct ListNode* newHead = NULL;
    while (head) {
        struct ListNode* tmpNode = head->next;
        head->next = newHead;
        newHead = head;
        head = tmpNode;
    }
    return newHead;
}
