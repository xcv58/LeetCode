#include <stdio.h>

struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
  ListNode *deleteDuplicates(ListNode *head) {
    for (ListNode *anchor = head, *base = head; anchor != NULL && base != NULL; anchor = anchor->next) {
      if (base->val == anchor->val) {
        base->next = anchor->next;
      } else {
        base = anchor;
      }
    }
    return head;
  }
};

int main() {
  return 0;
}
