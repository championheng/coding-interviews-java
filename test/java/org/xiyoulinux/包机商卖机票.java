package org.xiyoulinux;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: spider_hgyi
 * @Date: Create in 16:04 2018/4/2
 * @Modified By:
 * @Description:
 */
public class 包机商卖机票 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            if (n <= 0 || m <= 0) {
                System.out.println("good");
                continue;
            }

            boolean flag = false;
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    int sum = array[i];
                    for (int k = j; k < n; k++) {
                        if (sum > m) {
                            break;
                        }

                        if (sum != m) {
                            sum += array[k];
                        } else {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }

            if (flag) {
                System.out.println("prefect");
            } else {
                System.out.println("good");
            }
        }
    }
}
