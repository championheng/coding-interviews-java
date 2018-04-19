package org.xiyoulinux.回溯法;

/**
 * @Author: spider_hgyi
 * @Date: Create in 11:29 2018/4/7
 * @Modified By:
 * @Description:
 */
public class 机器人的运动范围 {
    public static void main(String[] args) {
        // 初始化二维数组
        int[][] matrix = new int[6][6];
        boolean[][] visited = new boolean[6][6];
        int k = 4;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int sum = getCheck(0, 0, rows, cols, k, 0, visited);

        System.out.println(sum);
    }

    // 得到格子数
    public static int getCheck(int i, int j, int rows, int cols, int k, int sum, boolean[][] visited) {
        // 如果坐标在正确的范围内，并且当前格子并未被访问
        if (i >= 0 && i < rows && j >= 0 && j < cols && !visited[i][j]) {
            // 得到当前格子的数位和
            int digitSum = getDigitSum(i, j);
            // 数位和满足小于 k 的条件
            if (digitSum <= k) {
                sum++;
                visited[i][j] = true;

                sum = getCheck(i - 1, j, rows, cols, k, sum, visited);      // up
                sum = getCheck(i, j + 1, rows, cols, k, sum, visited);      // right
                sum = getCheck(i + 1, j, rows, cols, k, sum, visited);      // down
                sum = getCheck(i, j - 1, rows, cols, k, sum, visited);      // left
            }
        }

        return sum;
    }

    // 坐标的数位和
    public static int getDigitSum(int i, int j) {
        int sum = 0;

        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }

        while (j != 0) {
            sum += j % 10;
            j /= 10;
        }

        return sum;
    }
}