import java.util.*;
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void combineLists(List<List<Integer>> src, List<List<Integer>> dest, int val) {
        for (List<Integer> tmpList : src) {
            ((LinkedList)tmpList).addFirst(val);
            dest.add(tmpList);
        }
        return;
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (root == null) {
            return lists;
        }

        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                lists.add(new LinkedList<Integer>(Arrays.asList(root.val)));
            }
        } else {
            this.combineLists(this.pathSum(root.left, sum - root.val), lists, root.val);
            this.combineLists(this.pathSum(root.right, sum - root.val), lists, root.val);
        }
        return lists;
    }
}
