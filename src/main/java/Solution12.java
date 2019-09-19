
/**
 * 调整数组顺序是奇数位于偶数前面
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

public class Solution12 {

    public void reOrderArray(int [] array) {
        if (array == null|| array.length <= 1) return;

        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i]%2 == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        int[] array1 = new int[count1];
        int[] array2 = new int[count2];

        int index1  = 0;
        int index2 = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]% 2 == 1) {
                array1[index1++] = array[i];
            } else {
                array2[index2++] = array[i];
            }
        }

        for (int i = 0; i < count1; i++) {
            array[i]= array1[i];
        }

        for (int i = 0; i < count2; i++) {
            array[i+count1] = array2[i];
        }
    }
}
