import java.util.*;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private HashMap<String, TreeNode> map;
    private HashMap<TreeNode, String> cache;
    private HashSet<String> duplicateSet;

    private void clear() {
        this.map = new HashMap<>();
        this.cache = new HashMap<>();
        this.duplicateSet= new HashSet<>();
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        this.clear();
        this.traversal(root);
        List<TreeNode> res = new ArrayList<>();
        for (String key : this.duplicateSet) {
            res.add(this.map.get(key));
        }
        return res;
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        String hash = this.hash(root);
        if (this.map.containsKey(hash)) {
            this.duplicateSet.add(hash);
        }
        this.map.put(hash, root);
        this.traversal(root.left);
        this.traversal(root.right);
    }

    private String hash(TreeNode root) {
        if (root == null) {
            return "x";
        }
        if (this.cache.containsKey(root)) {
            return this.cache.get(root);
        }
        String hash = root.val + "," + this.hash(root.left) + "," + this.hash(root.right);
        this.cache.put(root, hash);
        return hash;
    }
}
