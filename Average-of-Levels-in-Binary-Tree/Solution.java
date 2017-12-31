import java.util.ArrayList;
import java.util.List;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        while (level.size() > 0) {
            List<TreeNode> tmp = new ArrayList<>();
            Double sum = 0.0;
            int count = 0;
            for (TreeNode node : level) {
                if (node == null) {
                    continue;
                }
                sum += node.val;
                count++;
                tmp.add(node.left);
                tmp.add(node.right);
            }
            if (count > 0) {
                res.add(sum / count);
            }
            level = tmp;
        }
        return res;
    }
}
