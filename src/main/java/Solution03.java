/**
 *  重建二叉树
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Solution03 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        if (pre == null || in == null) return null;

        if (pre.length != in.length) return null;

        if (pre.length == 0) {
            return null;
        }

        int root = pre[0];
        int index = -1;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == root) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return null;
        }


        TreeNode rootNode = new TreeNode(root);

        int[] leftPre = new int[index];
        int[] leftIn = new int[index];
        int[] rightPre = new int[in.length - index-1];
        int[] rightIn = new int[in.length - index-1];

        for(int i = 0; i < index; i++) {
            leftPre[i] = pre[i+1];
        }

        for (int i = 0; i < in.length - index-1; i++) {
            rightPre[i] = pre[i+index+1];
        }

        for(int i = 0; i < index; i++) {
            leftIn[i] = in[i];
        }

        for (int i = 0; i < in.length - index-1; i++) {
            rightIn[i] = in[i + index + 1];
        }
        rootNode.left = reConstructBinaryTree(leftPre, leftIn);
        rootNode.right = reConstructBinaryTree(rightPre, rightIn);


        return rootNode;
    }
}


/**
 * Definition for binary tree
 *
 */
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

