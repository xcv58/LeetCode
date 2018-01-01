class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val == t.val) {
            if (this.isSametree(s.left, t.left) && this.isSametree(s.right, t.right)) {
                return true;
            }
        }
        return this.isSubtree(s.left, t) || this.isSubtree(s.right, t);
    }
    
    private boolean isSametree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return s.val == t.val && this.isSametree(s.left, t.left) && this.isSametree(s.right, t.right);
    }
}
