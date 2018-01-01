class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        boolean left = t.left != null;
        boolean right = t.right != null;
        if (left && right) {
            return t.val + "(" + this.tree2str(t.left) + ")" + "(" + this.tree2str(t.right) + ")";
        }
        if (!left && !right) {
            return String.valueOf(t.val);
        }
        if (left) {
            return t.val + "(" + this.tree2str(t.left) + ")";
        }
        return t.val + "()" + "(" + this.tree2str(t.right) + ")";
    }
}
