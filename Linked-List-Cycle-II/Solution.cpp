#include <stddef.h>

struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
  ListNode *detectCycle(ListNode *head) {
    for (ListNode *n1 = head, *n2 = head; n2 != NULL;) {
      n1 = n1->next;
      n2 = n2->next;
      if (n2 == NULL) {
        return NULL;
      }
      n2 = n2->next;
      if (n1 == n2) {
        for (n2 = head; n1 != n2; n1 = n1->next, n2 = n2->next);
        return n2;
      }
    }
    return NULL;
  }
};

int main() {
  return 0;
}
