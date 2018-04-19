package org.xiyoulinux.递归;

import java.util.Scanner;

/**
 * @Author: spider_hgyi
 * @Date: Create in 14:49 2018/3/28
 * @Modified By:
 * @Description:
 * 题目描述：有一对兔子，每隔3个月会再生一对兔子。那n个月后共有多少对兔子？
 */
public class 兔子问题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();

            int sum = rabbit(n);

            System.out.println(sum);
        }
    }

    public static int rabbit(int n) {
        if (n == 0) {
            return 1;
        }

        if (n % 3 == 0) {
            return 2 * rabbit(--n);
        } else {
            return rabbit(--n);
        }
    }
}
