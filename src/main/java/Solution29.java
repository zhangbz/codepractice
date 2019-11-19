/**
 * 连续子数组的最大和
 * 1.暴力
 * 2.动态规划
 */
public class Solution29 {
    public int FindGreatestSumOfSubArray(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }

        /**
         * 注意起始值不能默认设置为0，考虑arr元素均为<=0的情况
         */
        int curMax = array[0];
        int retMax = array[0];

        for (int i = 1; i < array.length; i++) {
            curMax = (array[i] > curMax + array[i]) ? array[i] : (array[i] + curMax);
            retMax = (retMax > curMax) ? retMax : curMax;
        }

        return retMax;
    }
}
