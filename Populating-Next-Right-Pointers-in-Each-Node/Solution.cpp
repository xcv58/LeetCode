/**
 * Definition for binary tree with next pointer.
 */
#include <stddef.h>
struct TreeLinkNode {
  int val;
  TreeLinkNode *left, *right, *next;
  TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
};

class Solution {
public:
  void connect(TreeLinkNode *root) {
    TreeLinkNode *anchor;
    while (root != NULL) {
      for (anchor = root; anchor->next != NULL; anchor = anchor->next) {
        if (anchor->left != NULL) {
          anchor->left->next = anchor->right;
          anchor->right->next = anchor->next->left;
        }
      }
      if (anchor->left != NULL) {
        anchor->left->next = anchor->right;
      }
      root = root->left;
    }
    return;
  }
};


int main() {
  Solution s;
  return 0;
}
