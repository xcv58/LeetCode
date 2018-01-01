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
  TreeNode *buildTree(vector<int> &inorder, vector<int> &postorder) {
    return buildTree(inorder, 0, inorder.size(), postorder, 0, postorder.size());
  }

  TreeNode *buildTree(vector<int> &inorder, int ini, int inj, vector<int> &postorder, int posti, int postj) {
    if (posti >= postj) {
      return NULL;
    }
    TreeNode *root = new TreeNode(postorder[postj - 1]);
    int leftLength = indexOf(postorder[postj - 1], inorder, ini, inj);
    if (leftLength != -1) {
      root->left = buildTree(inorder, ini, ini + leftLength, postorder, posti, posti + leftLength);
      root->right = buildTree(inorder, ini + leftLength + 1, inj, postorder, posti + leftLength, postj - 1);
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
