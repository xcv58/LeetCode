public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return this.buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode buildTree(int[] preorder, int prei, int prej, int[] inorder, int ini, int inj) {
        if (prei >= prej) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[prei]);
        int leftLength = this.indexOf(preorder[prei], inorder, ini, inj);
        if (leftLength != -1) {
            root.left = this.buildTree(preorder, prei + 1, prei + 1 + leftLength, inorder, ini, ini + leftLength);
            root.right = this.buildTree(preorder, prei + leftLength + 1, prej, inorder, ini + leftLength + 1, inj);
        }
        return root;
    }

    private int indexOf(int val, int[] target, int i, int j) {
        for (int index = i; index < j; index++) {
            if (target[index] == val) {
                return index - i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] preorder = new int[]{1, 2};
        int[] inorder = new int[]{2, 1};
        s.buildTree(preorder, inorder);
    }
}
