import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> largestValues(TreeNode root) {
        List<TreeNode> list = Collections.singletonList(root).stream().filter(x -> x != null).collect(Collectors.toList());
        List<Integer> res = new ArrayList<>();
        while (list.size() > 0) {
            List<TreeNode> tmp = new ArrayList<>();
            int max = Integer.MIN_VALUE;
            for (TreeNode node : list) {
                if (node == null) {
                    continue;
                }
                max = Math.max(max, node.val);
                tmp.add(node.left);
                tmp.add(node.right);
            }
            res.add(max);
            list = tmp.stream().filter(x -> x != null).collect(Collectors.toList());
        }
        return res;
    }
}
