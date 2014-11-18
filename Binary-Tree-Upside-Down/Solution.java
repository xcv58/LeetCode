import java.util.*;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        TreeNode anchor = stack.empty() ? null : stack.pop();

        for (root = anchor; !stack.empty() && anchor != null;  anchor.left = null, anchor.right = null) {
            anchor.right = stack.pop();
            anchor.left = anchor.right.right;
            anchor = anchor.right;
        }

        return root;
    }

    public TreeNode UpsideDownBinaryTreeO1Space(TreeNode root) {
        TreeNode superRoot = new TreeNode(0);
        TreeNode tmpRight = null;

        for (superRoot.left = root; superRoot.left != null;) {
            root = superRoot.left;
            superRoot.left = superRoot.left.left;

            root.left = tmpRight;
            tmpRight = root.right;

            root.right = superRoot.right;
            superRoot.right = root;
        }

        return superRoot.right;
    }
}
