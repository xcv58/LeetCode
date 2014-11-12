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
    vector<vector<int> > pathSum(TreeNode *root, int sum) {
        vector<vector<int> > lists;

        if (root == NULL) {
            return lists;
        }

        if (root->left == NULL && root->right == NULL) {
            if (sum == root->val) {
                lists.push_back(vector<int>(1, sum));
            }
        } else {
            combineLists(pathSum(root->left, sum - root->val), lists, root->val);
            combineLists(pathSum(root->right, sum - root->val), lists, root->val);
        }

        return lists;
    }

    void combineLists(vector<vector<int> > src, vector<vector<int> > & dest, int val) {
        for(int i = 0; i != src.size(); i++) {
            src[i].insert(src[i].begin(), val);
            dest.push_back(src[i]);
        }
        return;
    }
};

int main() {
  return 0;
}
