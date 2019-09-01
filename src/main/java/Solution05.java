/**
 * 旋转数组的最小数字
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Solution05 {
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int l = 0;
        int r = array.length -1;
        int mid = (l+r)/2;

        if (array[l] < array[r]) {
            return array[l];
        }

        if (array[l] ==array[mid] && array[r] == array[mid]) {
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i-1]) {
                    return array[i];
                }
            }
            return array[l];
        }


        while (l < r) {
            if (r-l == 1) {
                break;
            }

            mid = (l + r)/2;
            if (array[mid] >= array[l]) {//or array[mid] > array[r]
                l = mid;
            } else if (array[mid] <= array[r]){
                r = mid;
            }


        }

        return array[r];

    }
}
