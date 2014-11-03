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
        TreeLinkNode tmpRoot = root;
        TreeLinkNode tmpAnchor;
        while (tmpRoot != null) {
            tmpAnchor = tmpRoot;
            this.connectChildren(tmpAnchor);
            while (tmpAnchor.next != null) {
                if (tmpAnchor.left != null) {
                    tmpAnchor.right.next = tmpAnchor.next.left;
                }
                tmpAnchor = tmpAnchor.next;
                this.connectChildren(tmpAnchor);
            }
            tmpRoot = tmpRoot.left;
        }
        return;
    }

    private void connectChildren(TreeLinkNode root) {
        if (root.left != null) {
            root.left.next = root.right;
        }
    }
}
