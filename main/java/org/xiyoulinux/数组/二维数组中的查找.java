package org.xiyoulinux.数组;

import java.util.Scanner;

/**
 * @Author: spider_hgyi
 * @Date: Create in 11:20 2018/3/30
 * @Modified By:
 * @Description: 这一题没有使用什么算法，主要考察解决问题的能力及分析能力
 *
 * 注意此二维数组的规律，行递增，列递增
 */
public class 二维数组中的查找 {
    public static void main(String[] args) throws Exception {
        int[][] array1 ={{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int[][] array2 ={{1, 2, 3, 4}};
        int[][] array3 ={{}};

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            boolean isContain = findNumber(array3, number);

            System.out.println(isContain);
        }
    }

    /**
     * 实现思想：
     * 1. 以此二维数组的右上角或左下角为基准，本题中我以右上角为基准
     * 2. 如果要查找的数 number == 右上角的数，则返回 true
     * 3. 如果要查找的数 number 比右上角的数小，则抹除右上角数所在的列
     * 4. 如果要查找的数 number 比右上角的数大，则抹除右上角数所在的行
     * 5. 重复步骤 1-4
     * 6. 当二维数组被完全抹除时还没有找到合适的数，则返回 false
     */
    public static boolean findNumber(int[][] array, int number) throws Exception {
        if (array == null) {
            throw new Exception("array is null");
        }

        int row = array.length;
        int col = array[0].length;

        int i = 0;
        int j = col - 1;
        while (i <= row - 1 && j >= 0) {
            if (number == array[i][j]) {
                return true;
            } else if (number <array[i][j]) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }
}