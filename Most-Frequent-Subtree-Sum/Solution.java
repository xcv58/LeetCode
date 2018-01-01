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
        Integer max = map.values().stream().reduce(Integer::max).orElse(0);
        return map.entrySet().stream()
            .filter(p -> p.getValue() == max)
            .map(Map.Entry::getKey)
            .mapToInt(x -> x)
            .toArray();
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
