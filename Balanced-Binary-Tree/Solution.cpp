#include <iostream>
#include <algorithm>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    bool isBalanced(TreeNode *root) {
        return root == NULL || isBalanced(root->left, root->right, 1) >= 0;
    }

    int isBalanced(TreeNode *lChild, TreeNode *rChild, int depth) {
        int leftResult = lChild != NULL ? isBalanced(lChild->left, lChild->right, depth + 1) : depth;
        int rightResult = rChild != NULL ? isBalanced(rChild->left, rChild->right, depth + 1) : depth;
        return (min(leftResult, rightResult) < 0 || abs(leftResult - rightResult) > 1) ? -depth : max(leftResult, rightResult);
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
