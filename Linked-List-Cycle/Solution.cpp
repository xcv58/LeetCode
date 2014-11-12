#include <stddef.h>

struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
  bool hasCycle(ListNode *head) {
    for (ListNode *n1 = head, *n2 = head; n2 != NULL; n1 = n1->next, n2 = n2->next) {
      if (n2 == NULL || n2->next == NULL) {
        return false;
      }
      n2 = n2->next;
      if (n1 == n2) {
        return true;
      }
    }
    return false;
  }
};

int main() {
  return 0;
}
