import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    private List<List<Integer>> list;

    public int widthOfBinaryTree(TreeNode root) {
        this.list = new ArrayList<>();
        this.traversal(root, 0, 0);
        return this.list.stream().mapToInt(x -> this.getWidth(x)).max().orElse(0);
    }

    private int getWidth(List<Integer> list) {
        int min = list.stream().mapToInt(x -> x).min().orElse(0);
        int max = list.stream().mapToInt(x -> x).max().orElse(0);
        return max - min + (max * min >= 0 ? 1 : 0);
    }

    private void traversal(TreeNode root, int level, int gap) {
        if (root == null) {
            return;
        }
        this.getLevelList(level).add(gap);
        this.traversal(root.left, level + 1, gap * 2 - (gap >= 0 ? 1 : 0));
        this.traversal(root.right, level + 1, gap * 2 + (gap <= 0 ? 1 : 0));
    }

    private List<Integer> getLevelList(int level) {
        if (level >= this.list.size()) {
            List<Integer> newList = new ArrayList<>();
            this.list.add(newList);
        }
        return this.list.get(level);
    }
}
