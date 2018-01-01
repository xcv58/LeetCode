#include <cstddef>
#include <stack>
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
  vector<int> inorderTraversal(TreeNode *root) {
    vector<int> result;
    stack<TreeNode *> nodeStack;

    while (!nodeStack.empty() || root != NULL) {
      if (root != NULL) {
        nodeStack.push(root);
        root = root->left;
      } else if (!nodeStack.empty()) {
        root = nodeStack.top();
        nodeStack.pop();
        result.push_back(root->val);
        root = root->right;
      }
    }

    return result;
  }
};

int main() {
  return 0;
}
