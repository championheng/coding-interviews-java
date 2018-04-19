package org.xiyoulinux.位运算;

import java.util.Scanner;

/**
 * @Author: spider_hgyi
 * @Date: Create in 22:32 2018/4/7
 * @Modified By:
 * @Description:
 * 位运算中的左移与右移：
 * 左移：左移 n 位，则舍弃左边 n 位，右边 n 位补 0
 * 右移：分两种情况：
 *（1）正数：右移 n 位，左边 n 位补 0
 *（2）负数：右移 n 位，左边 n 位补 1
 *
 * 实现思想 1（不推荐）：在 Java 中不好实现
 *（1）将输入的数值与无符号的 1 进行与运算，并将无符号的 1 不断进行左移
 *（2）直到 1 为 0
 *
 * 实现思想 2（推荐）：
 * （1）将输入的数值不断进行减一然后与原数值进行与运算，直到原数值为 0 为止
 * （2）循环了多少次，则原数值中有多少个 1
 */
public class 二进制中1的个数 {
    // 解法 2
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean flag = true;

        int count = 0;
        while (flag) {
            if (n == 0) {
                flag = false;
            } else {
                count++;
                n &= n - 1;
            }
        }

        System.out.println(count);
    }
}