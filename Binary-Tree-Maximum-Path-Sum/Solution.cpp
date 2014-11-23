#include <limits>
using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
  int maxResult;

  int maxPathSum(TreeNode *root) {
    maxResult = numeric_limits<int>::min();
    privateMaxPathSum(root);
    return maxResult;
  }
private:
  int privateMaxPathSum(TreeNode *root) {
    if (root == NULL) {
      return 0;
    }

    int leftResult = root->val + privateMaxPathSum(root->left);
    int rightResult = root->val + privateMaxPathSum(root->right);

    int localmax = max(root->val, leftResult, rightResult);
    int sum = leftResult + rightResult - root->val;

    maxResult = max(localmax, sum, maxResult);

    return localmax;
  }
  int max(int a, int b, int c) {
    return (a > b && a > c) ? a : (b > c ? b : c);
  }
};

int main() {
  return 0;
}
