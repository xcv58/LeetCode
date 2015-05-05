#include <stdlib.h>

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        struct ListNode* newHead = NULL;
        while (head) {
            struct ListNode* tmpNode = head->next;
            head->next = newHead;
            newHead = head;
            head = tmpNode;
        }
        return newHead;
    }
};
