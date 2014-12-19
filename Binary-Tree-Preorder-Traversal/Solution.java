import java.util.*;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        for (stack.push(root); !stack.empty(); root = stack.pop()) {
            if (root != null) {
                resultList.add(root.val);
                stack.push(root.right);
                stack.push(root.left);
            }
        }
        return resultList;
    }
}
