public class Solution00 {

    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }

        int rows = array.length;//行数
        int cols = array[0].length;//列数

        boolean result = false;

        int i = 0;
        int j = cols - 1;
        while (i < rows && j >=0) {
            if (target == array[i][j]) {
                result = true;
                break;
            } else if (target < array[i][j]) {
                j--;
            } else {
                i++;
            }
        }

        return  result;

    }
}
