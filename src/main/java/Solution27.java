/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Solution27 {
    /**
     * 解法1 先排序，可以解决问题，但是不是考察目标
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution0(int[] array) {

        if (array == null || array.length == 0) return 0;//输入检查
        if (array.length == 1) return array[0];//边界情况处理

        bubbleSort(array);
        int tmp = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (tmp == array[i]) {
                count++;
                if (count > array.length / 2) return tmp;
            } else {
                tmp = array[i];
                count = 1;
            }
        }

        return 0;
    }

    private void bubbleSort(int[] array) {
        int tmp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {//冒泡排序别忘了这里应该是(n-i-1)
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 解法2：利用数组的中位数
     */
    public int MoreThanHalfNum_Solution(int[] array) {

        if (array == null || array.length == 0) return 0;//输入检查
        if (array.length == 1) return array[0];//边界情况处理


        int mid = array.length / 2;

        int index = partition(array, 0, array.length - 1);

        while (index != mid) {
            if (index > mid) {
                index = partition(array, 0, index - 1);
            } else {
                index = partition(array, index + 1, array.length - 1);
            }
        }

        int tmp = array[index];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == tmp) count++;
        }

        if (count > array.length / 2) return tmp;
        else return 0;
    }

    private int partition(int[] array, int low, int high) {
        int tmp = array[low];

        while (low < high) {
            while (array[high] >= tmp && low < high) {
                high--;
            }

            if (low < high) {
                array[low] = array[high];
                low++;
            }

            while (array[low] <= tmp && low < high) {
                low++;
            }

            if (low < high) {
                array[high] = array[low];
                high--;
            }
        }

        array[low] = tmp;
        return low;

    }

    /**
     * 解法3：利用"出现次数超过数组大小的一半"的条件
     *
     * 思路：数组中有一个数字出现的次数超过数组长度的一半，也就是说它出现的次数比其他所有数字出现次数的和还要多。
     * 因此我们可以考虑在遍历数组的时候保存两个值： 一个是数组中的一个数字， 一个是次数。当我们遍历到下一个数字的时候，如果下一个数字和我们之前保存的数字相同，则次数加1；
     * 如果下一个数字和我们之前保存的数字，不同，则次数减1 。如果次数为0，我们需要保存下一个数字，并把次数设为1 。
     * 由于我们要找的数字出现的次数比其他所有数字出现的次数之和还要多，那么要找的数字肯定是最后一次把次数设为1 时对应的数字。
     *
     */

}
