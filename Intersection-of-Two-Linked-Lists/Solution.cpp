#include <stdio.h>

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode *a = headA, *b = headB, *lastA = a, *lastB = b;
        for (; a != NULL && b != NULL; lastA = a, lastB = b, a = a->next, b = b->next);
        for (; b != NULL; lastB = b, b = b->next, headB = headB->next);
        for (; a != NULL; lastA = a, a = a->next, headA = headA->next);
        for (; headA != NULL && headB != NULL && headA != headB; headA = headA->next, headB = headB->next);
        return (lastA != lastB) ? NULL :headA;
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
