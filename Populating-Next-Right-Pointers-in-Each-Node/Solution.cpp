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
    for (; root != NULL; root = root->left) {
      for (anchor = root; anchor!= NULL; anchor = anchor->next) {
        if (anchor->left != NULL) {
          anchor->left->next = anchor->right;
          if (anchor->next == NULL) {
            break;
          }
          anchor->right->next = anchor->next->left;
        }
      }
    }
    return;
  }
};


int main() {
  Solution s;
  return 0;
}
