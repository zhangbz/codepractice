/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Solution25 {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        handleTree(pRootOfTree);
        return findMinNode(pRootOfTree);
    }

    private void handleTree(TreeNode rootNode) {
        if (rootNode == null) return;

        handleTree(rootNode.left);
        handleTree(rootNode.right);

        if (rootNode.left != null) {
            TreeNode maxLeftNode = findMaxLeftNode(rootNode.left);
            maxLeftNode.right = rootNode;
            rootNode.left = maxLeftNode;
        }

        if (rootNode.right != null) {
            TreeNode minRightNode = findMinRightNode(rootNode.right);
            minRightNode.left = rootNode;
            rootNode.right = minRightNode;
        }
    }

    private TreeNode findMaxLeftNode(TreeNode leftNode) {
        TreeNode maxLeftNode = leftNode;
        while (maxLeftNode.right != null) {
            maxLeftNode = maxLeftNode.right;
        }

        return maxLeftNode;
    }

    private TreeNode findMinRightNode(TreeNode rightNode) {
        TreeNode minRightNode = rightNode;
        while (minRightNode.left != null) {
            minRightNode = minRightNode.left;
        }

        return minRightNode;
    }

    private TreeNode findMinNode(TreeNode root) {
        TreeNode minNode = root;
        while (minNode.left != null) {
            minNode = minNode.left;
        }

        return minNode;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
