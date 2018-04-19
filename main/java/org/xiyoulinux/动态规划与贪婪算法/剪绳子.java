package org.xiyoulinux.动态规划与贪婪算法;

import java.util.Scanner;

/**
 * @Author: spider_hgyi
 * @Date: Create in 17:12 2018/4/7
 * @Modified By:
 * @Description:
 * 题目描述：一个长度为 n（n > 1）的绳子，剪成 m（m > 1） 段，n 与 m 都是整数，求剪下来的 m 段
 * 绳子长度乘积的最大值。
 *
 * 对问题的思考：
 * 1. 为什么使用动态规划？    求解一个问题的最优解，首先就应该想到dp，其次就是贪婪算法（动规的特例）
 * 2. 能够使用动规的问题的基本特征：
 * （1）问题可以进行分割，并且可以由局部最优解得到全局最优解
 * （2）在处理子问题的时候，可能会处理重复的子问题，此时需要开辟一块空间将已经处理过的问题
 * 保存下来，防止重复处理
 * （3）从上向下分析问题、从下向上解决问题
 *
 * 3. 本题的解决思路：
 * （1）题目描述将长度为 n 的绳子剪成 m 段，求得这 m 段乘积的最大值。我们可以先想象剪成两段的情况
 * （2）由于将长度为 n 的绳子剪成 2 段，则有 1 到 n - 1 这 n - 1 种剪法，假设我们剪得长度为 i，
 * 则相当于这样一个递推公式：f(n) = max(f(i) * f(n - i))
 * （3）那我们对剪后产生的每一段绳子应用这样一个公式，将问题分解成子问题，并得出每个子问题的最优解，
 * 全局最优解自然解决
 */
public class 剪绳子 {
    public static void main(String[] args) {
        // 输入绳子的长度
        Scanner scanner = new Scanner(System.in);
               int length = scanner.nextInt();

        // 求解绳子被剪 m 段之后，m 段绳子乘积的最大值（m 的值并不确定）
        int max = maxProductAfterCutting(length);

        System.out.println(max);
    }

    public static int maxProductAfterCutting(int length) {
        // 先确定基本情况
        if (length < 2) {
            return 0;
        }

        if (length == 2) {
            return 1;
        }

        if (length == 3) {
            return 2;
        }

        // 确定基本子问题的解（打表）
        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }

                products[i] = max;
            }
        }

        max = products[length];

        return max;
    }
}