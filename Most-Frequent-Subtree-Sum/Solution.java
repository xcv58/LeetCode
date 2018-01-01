import java.util.*;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<TreeNode, Integer> cache = new HashMap<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        this.traversal(root, map, cache);
        int max = 0;
        for (Integer i : map.values()) {
            if (max < i) {
                max = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == max) {
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void traversal(TreeNode root, HashMap<Integer, Integer> map, HashMap<TreeNode, Integer> cache) {
        if (root == null) {
            return;
        }
        int sum = this.getSum(root, cache);
        int count = map.getOrDefault(sum, 0);
        map.put(sum, count + 1);
        this.traversal(root.left, map, cache);
        this.traversal(root.right, map, cache);
    }

    private int getSum(TreeNode root, HashMap<TreeNode, Integer> cache) {
        if (root == null) {
            return 0;
        }
        Integer sum = cache.get(root);
        if (sum == null) {
            sum = root.val + this.getSum(root.left, cache) + this.getSum(root.right, cache);
        }
        cache.put(root, sum);
        return sum;
    }
}
