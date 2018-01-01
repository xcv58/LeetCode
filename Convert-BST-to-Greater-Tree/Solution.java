class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private TreeNode preNode = null;

    public TreeNode convertBST(TreeNode root) {
        this.preNode = null;
        this.traversal(root);
        return root;
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        this.traversal(root.right);
        root.val += preNode == null ? 0 : preNode.val;
        preNode = root;
        this.traversal(root.left);
    }
}
