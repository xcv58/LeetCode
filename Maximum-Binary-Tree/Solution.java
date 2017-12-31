class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return this.constructMaximumBinaryTree(nums, 0, nums.length);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int i, int j) {
        if (i >= j) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        int pivot = i;
        for (int tmp = i; tmp < j; tmp++) {
            if (max < nums[tmp]) {
                max = nums[tmp];
                pivot = tmp;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = this.constructMaximumBinaryTree(nums, i, pivot);
        root.right = this.constructMaximumBinaryTree(nums, pivot + 1, j);
        return root;
    }
}
