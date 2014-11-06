#include <stdio.h>

/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
  bool hasPathSum(TreeNode *root, int sum) {
    if (root == NULL) {
      return false;
    }
    if (root->left == NULL && root->right == NULL) {
      return sum == root->val;
    }
    return (root->left == NULL ? false : hasPathSum(root->left, sum - root->val))
      ||
      (root->right == NULL ? false : hasPathSum(root->right, sum - root->val));
  }
};

int main() {
  return 0;
}
