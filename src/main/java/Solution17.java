/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Solution17 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void Mirror(TreeNode root) {
        if (root == null) return;

        swapNode(root);
        Mirror(root.left);
        Mirror(root.right);

    }

    private void swapNode(TreeNode root) {
        if (root == null) return;

        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;
    }
}
