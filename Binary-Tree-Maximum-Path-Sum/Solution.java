public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int maxResult = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root){
        this.privateMaxPathSum(root);
        return maxResult;
    }

    private int privateMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftResult = root.val + this.privateMaxPathSum(root.left);
        int rightResult = root.val + this.privateMaxPathSum(root.right);

        int localmax = this.max(root.val, leftResult, rightResult);
        int sum = leftResult + rightResult - root.val;

        this.maxResult = this.max(localmax, sum, maxResult);

        return localmax;
    }

    private int max(int a, int b, int c){
        return (a > b && a > c) ? a : (b > c ? b : c);
    }
}
