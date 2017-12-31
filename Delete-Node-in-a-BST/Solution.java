class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val != key) {
            root.left = this.deleteNode(root.left, key);
            root.right = this.deleteNode(root.right, key);
            return root;
        }
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        TreeNode left = root.left;
        while (left.right != null) {
            left = left.right;
        }
        left.right = root.right;
        return root.left;
    }
}
