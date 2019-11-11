import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Solution18 {

    public static void main(String[] args) {
        int[][] matrix = new int[3][5];
        int k = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = k++;
            }
        }

        ArrayList<Integer> integers = printMatrix(matrix);

        for (int i = 0; i < integers.size(); i++) {
            System.out.println(i + " : " + integers.get(i));
        }
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null) return result;
        if (matrix.length == 0) return result;
        if (matrix.length == 1) {
            for (int i = 0; i < matrix[0].length; i++) {
                result.add(matrix[0][i]);
            }

            return result;
        }
        if (matrix[0].length == 1) {
            for (int i = 0; i < matrix.length;i++) {
                result.add(matrix[i][0]);
            }

            return result;
        }

        int minX = 0;
        int maxX = matrix.length - 1;
        int minY = 0;
        int maxY = matrix[0].length - 1;
        int tmpX = minX;
        int tmpY = minY;

        while (minX < maxX && minY < maxY) {

            for (; tmpY <= maxY; tmpY++) {
                result.add(matrix[tmpX][tmpY]);
            }
            maxY--;


            for (tmpX++, tmpY--; tmpX <= maxX; tmpX++) {
                result.add(matrix[tmpX][tmpY]);
            }
            maxX--;


            for (tmpX--, tmpY--; tmpY >= minY; tmpY--) {
                result.add(matrix[tmpX][tmpY]);
            }
            minY++;


            minX++;
            for (tmpX--, tmpY++; tmpX >= minX; tmpX--) {
                result.add(matrix[tmpX][tmpY]);
            }

            tmpX++;
            tmpY++;

        }

        if (minX == maxX && minY < maxY) {
            for (; tmpY <= maxY; tmpY++) {
                result.add(matrix[tmpX][tmpY]);

            }

        }

        if (minY == maxY && minX < maxX) {
            for (; tmpX <= maxX; tmpX++) {
                result.add(matrix[tmpX][tmpY]);
            }
        }

        if (minX == maxX && minY == maxY) {
            result.add(matrix[tmpX][tmpY]);
        }

        return result;

    }
}
