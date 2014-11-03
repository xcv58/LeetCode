/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode anchor;
        while (root != null) {
            for (anchor = root;  anchor.next != null; anchor = anchor.next) {
                if (anchor.left != null) {
                    anchor.left.next = anchor.right;
                    anchor.right.next = anchor.next.left;
                }
            }
            if (anchor.left != null) {
                anchor.left.next = anchor.right;
            }
            root = root.left;
        }
        return;
    }
}
