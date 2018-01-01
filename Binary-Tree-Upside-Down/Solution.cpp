#include <cstddef>
#include <vector>

using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
  TreeNode *upsideDownBinaryTree(TreeNode *root) {
    vector<TreeNode*> nodes;

    for (;root != NULL; nodes.push_back(root), root = root->left);

    TreeNode *anchor = nodes.size() > 0 ? nodes[nodes.size() - 1] : NULL;

    root = anchor;
    for (int i = nodes.size() - 2; i >= 0 && anchor != NULL; i--, anchor->left = NULL, anchor->right = NULL) {
      anchor->right = nodes[i];
      anchor->left = anchor->right->right;
      anchor = anchor->right;
    }

    return root;
  }

  TreeNode *upsideDownBinaryTreeO1Space(TreeNode *root) {
    TreeNode *superRoot = new TreeNode(0);
    TreeNode *tmpRight = NULL;

    for (superRoot->left = root; superRoot->left != NULL;) {
      root = superRoot->left;
      superRoot->left = superRoot->left->left;

      root->left = tmpRight;
      tmpRight = root->right;

      root->right = superRoot->right;
      superRoot->right = root;
    }

    return superRoot->right;
  }
};

int main() {
  return 0;
}
