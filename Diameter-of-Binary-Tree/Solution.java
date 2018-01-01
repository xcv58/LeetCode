class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        this.max = 0;
        this.traversal(root);
        return this.max;
    }
    
    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        this.max = Math.max(this.max, this.height(root.left) + this.height(root.right));
        this.traversal(root.left);
        this.traversal(root.right);
    }
    
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(this.height(root.left), this.height(root.right));
    }
}
