import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。（层序遍历）
 * 1.注意考虑root为null的边界情况
 * 2.注意二叉树的子节点为null的情况
 * 3.队列的初始化：Queue<TreeNode> queue = new LinkedList<>();
 */
public class Solution21 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode tmp;
        while (!queue.isEmpty()) {
            tmp = queue.poll();
            result.add(tmp.val);
            if (tmp.left != null) {
                queue.add(tmp.left);
            }

            if (tmp.right != null) {
                queue.add(tmp.right);
            }

        }

        return result;


    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

}