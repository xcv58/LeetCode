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
  TreeNode *sortedArrayToBST(vector<int> &num) {
    return sortedArrayToBST(num, 0, num.size());
  }

  TreeNode *sortedArrayToBST(vector<int> &num, int start, int end) {
    if (start + 1 >= end) {
      return start + 1 == end ? new TreeNode(num[start]) : NULL;
    }

    int mid = (start + end) / 2;
    TreeNode *root = new TreeNode(num[mid]);
    root->left = sortedArrayToBST(num, start, mid);
    root->right = sortedArrayToBST(num, mid + 1, end);

    return root;
  }
};

int main() {
  return 0;
}
