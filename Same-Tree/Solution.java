public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return (p == null || q == null) ? p == q : p.val == q.val && this.isSameTree(p.left, q.left) && this.isSameTree(p.right, q.right);
    }
}
