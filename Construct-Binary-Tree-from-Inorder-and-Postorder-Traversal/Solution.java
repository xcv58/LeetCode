public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode buildTree(int[] inorder, int ini, int inj, int[] postorder, int posti, int postj) {
        if (posti >= postj) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postj - 1]);
        int leftLength = this.indexOf(postorder[postj - 1], inorder, ini, inj);
        if (leftLength != -1) {
            root.left = this.buildTree(inorder, ini, ini + leftLength, postorder, posti, posti + leftLength);
            root.right = this.buildTree(inorder, ini + leftLength + 1, inj, postorder, posti + leftLength, postj - 1);
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
