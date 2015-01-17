public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {
        return root == null || this.isBalanced(root.left, root.right, 1) >= 0;
    }

    private int isBalanced(TreeNode left, TreeNode right, int depth) {
        int leftResult = left != null ? this.isBalanced(left.left, left.right, depth + 1) : depth;
        int rightResult = right != null ? this.isBalanced(right.left, right.right, depth + 1) : depth;
        return (Math.min(leftResult, rightResult) < 0 || Math.abs(leftResult - rightResult) > 1) ? -depth : Math.max(leftResult, rightResult);
    }
}
