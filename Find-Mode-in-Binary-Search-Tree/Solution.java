class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private TreeNode preNode = null;
    private int currentCount = 0;
    private int maxCount = 0;
    
    private void clear() {
        this.preNode = null;
        this.currentCount = 0;
        this.maxCount = 0;
    }

    public int[] findMode(TreeNode root) {
        this.clear();

        List<Integer> list = new ArrayList<>();
        this.traversal(root, list);

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    
    private void traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        this.traversal(root.left, list);
        if (preNode == null) {
            preNode = root;
        }
        if (preNode.val == root.val) {
            this.currentCount++;
        } else {
            this.currentCount = 1;
        }
        if (this.currentCount > this.maxCount) {
            this.maxCount = this.currentCount;
            list.clear();
            list.add(root.val);
        } else if (this.currentCount == this.maxCount) {
            list.add(root.val);
        }
        preNode = root;
        this.traversal(root.right, list);
    }
}
