package org.xiyoulinux;

import java.util.Scanner;

/**
 * @Author: spider_hgyi
 * @Date: Create in 15:42 2018/4/5
 * @Modified By:
 * @Description:
 */
public class 翻转数列 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            if (n < 2 || n > Math.pow(10, 9) || m < 1) {
                System.out.println(0);
                continue;
            }

            if (n % (2 * m) != 0) {
                System.out.println(0);
                continue;
            }

            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = (i + 1) * (-1);
            }

            int count = 1;
            int i = 0;
            boolean flag = false;
            while (i < n) {
                if (!flag) {
                    count = 1;
                    while (count <= m) {
                        count++;
                        i++;
                    }
                    flag = true;
                } else {
                    count = 1;
                    while (count <= m) {
                        array[i] = array[i] * -1;
                        count++;
                        i++;
                    }
                    flag = false;
                }
            }

            for (int j = 0; j < n; j++) {
                System.out.print(array[j] + " ");
            }
            System.out.println();

            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += array[j];
            }

            System.out.println(sum);
        }
    }
}
