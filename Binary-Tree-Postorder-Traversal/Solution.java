import java.util.*;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        for (stack.push(root); !stack.empty(); root = stack.pop()) {
            if (root != null) {
                resultList.add(root.val);
                stack.push(root.left);
                stack.push(root.right);
            }
        }
        Collections.reverse(resultList);
        return resultList;
    }
}
