import java.util.*;
import java.util.stream.Collectors;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class Solution {
    class Node {
        TreeNode root;
        int index;

        public Node(TreeNode root, int index) {
            this.root = root;
            this.index = index;
        }
    }

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        int height = this.height(root);
        if (height == 0) {
            return res;
        }
        int width = (int) Math.pow(2, height) - 1;
        List<Node> list = Collections.singletonList(new Node(root, width / 2));
        while (list.size() > 0) {
            List<String> levelList = new ArrayList<>();
            list = this.getList(list, levelList, res.size(), height, width);
            res.add(levelList);
        }
        return res;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(this.height(root.left), this.height(root.right));
    }


    private List<Node> getList(List<Node> list, List<String> levelList, int depth, int height, int width) {
        List<Node> res = new ArrayList<>();
        int delta = (int) Math.pow(2, height - depth - 2);
        for (Node node : list) {
            this.fillList(levelList, node.index);
            levelList.add(String.valueOf(node.root.val));
            res.add(new Node(node.root.left, node.index - delta));
            res.add(new Node(node.root.right, node.index + delta));
        }
        this.fillList(levelList, width);
        return res.stream().filter(x -> x.root != null).collect(Collectors.toList());
    }

    private void fillList(List<String> list, int end) {
        while (list.size() < end) {
            list.add("");
        }
    }
}
