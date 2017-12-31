public class Codec {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static final String DELIMITER = "-";
    private static final String NULL = " ";
    private int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return NULL;
        }
        return root.val + DELIMITER + this.serialize(root.left) + DELIMITER + this.serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(this.DELIMITER);
        this.index = 0;
        return this.deserialize(nodes);
    }

    private TreeNode deserialize(String[] nodes) {
        if (index >= nodes.length) {
            return null;
        }
        String node = nodes[this.index++];
        if (node.equals(NULL)) {
            return null;
        }
        int val = Integer.parseInt(node);
        TreeNode root = new TreeNode(val);
        root.left = this.deserialize(nodes);
        root.right = this.deserialize(nodes);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
