class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int number;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        this.number = 0;
        this.traversal(root, sum);
        return this.number;
    }
    
    private void traversal(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        this.number += this.rootPathSum(root, sum);
        this.traversal(root.left, sum);
        this.traversal(root.right, sum);
    }

    private int rootPathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int target = sum - root.val;
        return this.rootPathSum(root.left, target) + this.rootPathSum(root.right, target) + (target == 0 ? 1 : 0);
    }
}
