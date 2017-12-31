class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private TreeNode treeNode(int val, TreeNode left, TreeNode right) {
        TreeNode root = new TreeNode(val);
        root.left = left;
        root.right = right;
        return root;
    }

    private TreeNode treeNode(int val, TreeNode left) {
        return this.treeNode(val, left, null);
    }
        
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            return this.treeNode(v, root);
        }
        List<TreeNode> list = Collections.singletonList(root);
        while (d > 2) {
            List<TreeNode> tmp = new ArrayList<>();
            for (TreeNode node : list) {
                if (node == null) {
                    continue;
                }
                tmp.add(node.left);
                tmp.add(node.right);
            }
            list = tmp;
            d--;
        }
        for (TreeNode node : list) {
            this.addOneRow(node, v);
        }
        return root;
    }
    
    private void addOneRow(TreeNode parent, int v) {
        if (parent == null) {
            return;
        }
        TreeNode left = parent.left;
        TreeNode right = parent.right;
        parent.left = new TreeNode(v);
        parent.left.left = left;
        parent.right = new TreeNode(v);
        parent.right.right = right;
    }
}
