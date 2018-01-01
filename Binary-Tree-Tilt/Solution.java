import java.util.*;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private HashMap<TreeNode, Integer> sumMap;

    public int findTilt(TreeNode root) {
        this.sumMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        this.traversal(root, list);
        return list.stream().mapToInt(i -> i).sum();
    }

    private void traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(this.tilt(root));
        this.traversal(root.left, list);
        this.traversal(root.right, list);
    }
    
    private int tilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.abs(this.getSum(root.left) - this.getSum(root.right));
    }

    private Integer getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Integer sum = this.sumMap.get(root);
        if (sum == null) {
            sum = root.val + this.getSum(root.left) + this.getSum(root.right);
            this.sumMap.put(root, sum);
        }
        return sum;
    }
}
