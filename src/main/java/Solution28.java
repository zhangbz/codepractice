import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * <p>
 * 基于堆排序算法，构建最大堆。时间复杂度为O(nlogk)
 * 如果用快速排序，时间复杂度为O(nlogn)；
 * 如果用冒泡排序，时间复杂度为O(n*k)
 */
public class Solution28 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length == 0 || input.length < k|| k == 0) {
            return result;
        }

        int[] minK = new int[k];
        for (int i = 0; i < k; i++) {
            minK[i] = input[i];
        }

        for (int i = k / 2 - 1; i >= 0; i--) {
            adjustMaxHeap(minK, i, k);
        }

        for (int i = k; i < input.length; i++) {
            if (input[i] < minK[0]) {
                minK[0] = input[i];
                adjustMaxHeap(minK,0, k);
            }
        }

        for (int i = 0; i < k; i++) {
            result.add(minK[i]);
        }

        return result;

    }

    private void adjustMaxHeap(int[] input, int pos, int length) {
        int tmp = input[pos];
        int child = 2 * pos + 1;
        for (; child < length; child = 2 * pos + 1) {
            if (child+ 1 < length && input[child] < input[child + 1]) {
                child += 1;
            }

            if (input[child] > tmp) {
                input[pos] = input[child];
                pos = child;
            } else {
                break;
            }
        }
        input[pos] = tmp;
    }
}
