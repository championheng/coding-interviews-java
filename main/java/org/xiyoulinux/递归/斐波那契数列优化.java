package org.xiyoulinux.递归;

import java.util.Scanner;

/**
 * @Author: spider_hgyi
 * @Date: Create in 15:31 2018/3/28
 * @Modified By:
 * @Description:
 */
public class 斐波那契数列优化 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();

//            int sum = fibonacci(n);
            int sum = fibonacci(n, 1, 1);

            System.out.println(sum);
        }
    }

    // 递归
//    public static int fibonacci(int n) {
//        if (n == 1 || n == 2) {
//            return 1;
//        }
//
//        return fibonacci(--n) + fibonacci(--n);
//    }

    // 循环
    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        int f1 = 1;
        int f2 = 1;
        int fn = 0;

        for (int i = 3; i <= n; i++) {
            fn = f1 + f2;
            f1 = f2;
            f2 = fn;
        }

        return fn;
    }

    // 尾递归
    public static int fibonacci(int n, int f1, int f2) {
        if (n <= 2) {
            return f2;
        } else {
            System.out.printf("factorial_tail(%d, %d, %d) \n", n - 1, f2, f1 + f2);
            return fibonacci(n - 1, f2, f1 + f2);
        }
    }
}