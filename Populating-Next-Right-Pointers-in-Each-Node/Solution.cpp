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
    TreeLinkNode *tmpRoot = root;
    TreeLinkNode *tmpAnchor;
    while (tmpRoot != NULL) {
      tmpAnchor = tmpRoot;
      connectChildren(tmpAnchor);
      while (tmpAnchor->next != NULL) {
        if (tmpAnchor->left != NULL) {
          tmpAnchor->right->next = tmpAnchor->next->left;
        }
        tmpAnchor = tmpAnchor->next;
        connectChildren(tmpAnchor);
      }
      tmpRoot = tmpRoot->left;
    }
    return;
  }

  void connectChildren(TreeLinkNode *root) {
    if (root->left != NULL) {
      root->left->next = root->right;
    }
  }
};


int main() {
  Solution s;
  return 0;
}
