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
  TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder) {
    return buildTree(preorder, 0, preorder.size(), inorder, 0, inorder.size());
  }

  TreeNode *buildTree(vector<int> &preorder, int prei, int prej, vector<int> &inorder, int ini, int inj) {
    if (prei >= prej) {
      return NULL;
    }
    TreeNode *root = new TreeNode(preorder[prei]);
    int leftLength = indexOf(preorder[prei], inorder, ini, inj);
    if (leftLength != -1) {
      root->left = buildTree(preorder, prei + 1, prei + 1 + leftLength, inorder, ini, ini + leftLength);
      root->right = buildTree(preorder, prei + leftLength + 1, prej, inorder, ini + leftLength + 1, inj);
    }
    return root;
  }

  int indexOf(int val, vector<int> &target, int i, int j) {
    for (int index = i; index < j; index++) {
      if (target[index] == val) {
        return index - i;
      }
    }
    return -1;
  }
};

int main() {
  return 0;
}
