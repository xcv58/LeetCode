public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] num) {
        return this.sortedArrayToBST(num, 0, num.length);
    }

    public TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if (start + 1 >= end) {
            return start + 1 == end ? new TreeNode(num[start]) : null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = this.sortedArrayToBST(num, start, mid);
        root.right = this.sortedArrayToBST(num, mid + 1, end);

        return root;
    }
}
