#include <stdio.h>

struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
  ListNode *sortList(ListNode *head) {
    int len = 0;
    int section = 1;

    ListNode *anchor = head;
    ListNode *parent = new ListNode(0);
    ListNode *superHead = parent;
    parent->next = head;

    while (true) {
      if (anchor == NULL) {
        section *= 2;
        if (section > len) {
          break;
        }
        parent = superHead;
        anchor = parent->next;
        continue;
      }
      ListNode *h1 = anchor;
      ListNode *h2 = cut(anchor, section);
      anchor = cut(h2, section);
      parent = combineSortedList(parent, h1, h2);
      len += section == 1 ? 2 : 0;
    }

    return superHead->next;
  }
  ListNode * cut(ListNode *head, int len) {
    for (; len > 1 && head != NULL; len--, head = head->next);
    if (head == NULL) {
      return NULL;
    }
    ListNode *nextHead = head->next;
    head->next = NULL;
    return nextHead;
  }

  ListNode * combineSortedList(ListNode *parent, ListNode *h1, ListNode *h2) {
    while (h1 != NULL && h2 != NULL) {
      parent->next = h1->val < h2->val ? h1 : h2;
      parent = parent->next;
      if (h1->val < h2->val) {
        h1 = h1->next;
      } else {
        h2 = h2->next;
      }
    }
    for (parent->next = h1 != NULL ? h1 : h2; parent->next != NULL; parent = parent->next);
    return parent;
  }
};

int main() {
  return 0;
}
