import java.util.*;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else if (!stack.empty()) {
                root = stack.pop();
                resultList.add(root.val);
                root = root.right;
            }
        }
        return resultList;
    }
}
