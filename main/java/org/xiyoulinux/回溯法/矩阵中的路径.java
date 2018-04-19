package org.xiyoulinux.回溯法;

import java.util.Scanner;

/**
 * @Author: spider_hgyi
 * @Date: Create in 11:46 2018/4/6
 * @Modified By:
 * @Description:
 * 实现思想：
 * 1. 首先从矩阵中找到字符串的第一个字符，也就是字符串的入口（若没有则返回 false）
 * 2. 在边界范围内，依次对当前字符的上、下、左、右方向进行访问，并判断字符串中下一个字符所在的正确路径
 * 3. 若在当前位置没有找到符合条件的下一个正确路径，则对当前位置进行回退，重新寻找合适的路径
 * 4. 如果整个矩阵中都没有合适的路径则返回 false，否则返回 true
 *
 * 注：已经遍历过的路径不再进行遍历，因此额外需要一个二维的 boolean 数组，用来记录已经遍历过的路径
 */
public class 矩阵中的路径 {
    public static void main(String[] args) throws Exception {
        char[][] matrix = {{'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'}, {'j', 'd', 'e', 'h'}};

        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();

        boolean hasPath = hasPath(string, matrix);

        System.out.println(hasPath);
    }

    public static boolean hasPath(String string, char[][] matrix) throws Exception {
        if (string == null || matrix == null) {
            throw new Exception("string | matrix is null");
        }

        if (string.length() == 0 || matrix.length == 0) {
            throw new Exception("string | matrix length is 0");
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // 设置 boolean 矩阵，标记哪些矩阵中哪些路径已经被访问
        boolean[][] visited = new boolean[rows][cols];
        // 标记访问的是字符串中的第几个字符
        int pathLength = 0;

        // 从矩阵的第一个元素开始，依次寻找路径
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, rows, cols, row, col, string, pathLength, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean hasPathCore(char[][] matrix, int rows, int cols, int row,
                                      int col, String string, int pathLength, boolean[][] visited) {
        // 遍历完整个字符串
        if (pathLength == string.length()) {
            return true;
        }

        boolean hasPath = false;

        if (row >= 0 && row < rows && col >= 0 && col < cols &&
                matrix[row][col] == string.charAt(pathLength) && !visited[row][col]) {
            pathLength++;
            visited[row][col] = true;

            // 四个方向中有一个符合条件就可以返回 true
            hasPath = hasPathCore(matrix, rows, cols, row, col - 1, string, pathLength , visited) ||
                    hasPathCore(matrix, rows, cols, row, col + 1, string, pathLength, visited) ||
                    hasPathCore(matrix, rows, cols, row - 1, col, string, pathLength, visited) ||
                    hasPathCore(matrix, rows, cols, row + 1, col, string, pathLength, visited);

            if (!hasPath) {
                pathLength--;
                visited[row][col] = false;
            }
        }

        return hasPath;
    }
}