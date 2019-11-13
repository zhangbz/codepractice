/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 1.牢记检查入参是否合法
 * 2.二叉搜索树的后序遍历特点：每个子树的左子树的节点均小于根节点，右子树的节点均大于根节点
 */
public class Solution22 {

    public boolean VerifySquenceOfBST(int[] sequence) {

        if (sequence == null || sequence.length == 0) return false;
        return isBST(sequence, 0, sequence.length - 1);
    }

    private boolean isBST(int[] sequence, int start, int end) {
        if (end <= start) return true;
        int i = start;
        for (; i < end; i++) {
            if (sequence[i] > sequence[end]) break;
        }

        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end]) return false;
        }

        return isBST(sequence, start, i - 1) && isBST(sequence, i, end - 1);
    }
}