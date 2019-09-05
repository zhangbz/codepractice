/**
 * 变态跳台阶
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */

public class Solution08 {

    /**
     * 递归实现
     * @param target
     * @return
     */
    public int JumpFloorII0(int target) {
        if(target==0||target==1)
            return 1;
        int sum = 0;
        for(int i=0;i<target;i++){
            sum += JumpFloorII(i);
        }
        return sum;
    }

    /**
     * 贪心
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        if (target == 0 || target == 1) {
            return 1;
        }

        int[] arr = new int[target+1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < target+1; i++) {
            arr[i] = 2 * arr[i - 1];
        }

        return arr[target];
    }
}
