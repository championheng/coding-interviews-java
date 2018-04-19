package org.xiyoulinux.递归;

import java.util.Scanner;

/**
 * @Author: spider_hgyi
 * @Date: Create in 17:20 2018/4/1
 * @Modified By:
 * @Description:
 * 题目描述：青蛙每次可以跳一个台阶或两个台阶，求n个台阶，青蛙有多少种跳法？
 */
public class 青蛙跳台阶 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int sum = result(n, 1, 2);
            System.out.println(sum);
        }
    }

    // 尾递归
    public static int result(int n, int f1, int f2) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return f1;
        }

        if (n == 2) {
            return f2;
        }

        return result(--n, f2, f1 + f2);
    }
}