class Solution {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public int findSecondMinimumValue(TreeNode root) {
        return this.findLargeThan(root, root.val);
    }

    public int findLargeThan(TreeNode root, int target) {
        if (root == null) {
            return -1;
        }
        if (root.val > target) {
            return root.val;
        }
        int left = this.findLargeThan(root.left, target);
        int right = this.findLargeThan(root.right, target);
        if (left >= 0 && right >= 0) {
            return Math.min(left, right);
        }
        return Math.max(left, right);
    }
}
