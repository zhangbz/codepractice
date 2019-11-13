import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 *
 * 不仅要会二叉树的遍历，还要会基于二叉树遍历的逻辑处理
 * 注意值传递与引用传递的区别
 *
 */
public class Solution23 {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> resultLists = new ArrayList<>();
        if (root == null) {
            return resultLists;
        }
        ArrayList<Integer> currentList = new ArrayList<>();
        int sum = 0;
        dfs(root, target, sum, currentList, resultLists);
        return resultLists;
    }

    private void dfs(TreeNode root, int target, int sum, ArrayList<Integer> currentList, ArrayList<ArrayList<Integer>> targetLists) {
        if (root == null) {
            return;
        }
        sum += root.val;

        if (root.left == null && root.right == null) {
            if (sum == target) {
                currentList.add(root.val);
//                targetLists.add(currentList);
                targetLists.add(new ArrayList<>(currentList));//注意这里要new一个，不能直接add currentList
                currentList.remove(currentList.size() - 1);
//                sum -= root.val;
            }

            return;
        }

        currentList.add(root.val);
        dfs(root.left, target, sum, currentList, targetLists);
        dfs(root.right, target, sum, currentList, targetLists);
        currentList.remove(currentList.size() - 1);
//        sum -= root.val;//我理解之所以current需要重置的处理，而sum不需要，是因为基本类型是值传递，而currentList是引用传递
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
