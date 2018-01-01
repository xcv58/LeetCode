#include <algorithm>
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
  vector<int> postorderTraversal(TreeNode *root) {
    vector<int> result;
    stack<TreeNode *> nodeStack;

    for(nodeStack.push(root); !nodeStack.empty(); root = nodeStack.top(), nodeStack.pop()) {
      if (root != NULL) {
        result.push_back(root->val);
        nodeStack.push(root->left);
        nodeStack.push(root->right);
      }
    }
    reverse(result.begin(),result.end());
    return result;
  }
};

int main() {
  return 0;
}
