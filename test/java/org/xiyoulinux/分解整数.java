package org.xiyoulinux;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author: spider_hgyi
 * @Date: Create in 19:59 2018/4/9
 * @Modified By:
 * @Description:
 */
public class 分解整数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        Map<Long, Long> map = new TreeMap<>();

        if (t >= 1 && t <= 1000) {
            for (int i = 0; i < t; i++) {
                Long N = scanner.nextLong();
                if (N >= 2 && N < Math.pow(2, 63)) {
                    if (!isPowerOfTwo(N)) {
                        map = new TreeMap<>();
                        for (Long x = 1L; x <= N / 2; x++) {
                            // x 为奇数
                            if (x % 2 == 1) {
                                if (N % x == 0) {
                                    Long y = N / x;
                                    // y 为偶数
                                    if (y % 2 == 0) {
                                        map.put(y, x);
                                    }
                                }
                            }
                        }
                    }
                }

                if (map.size() == 0) {
                    System.out.println("No");
                } else {
                    System.out.println(map.entrySet().iterator().next().getValue() + " " + map.entrySet().iterator().next().getKey());
                }
            }
        }
    }

    // 判断 N 是否是 2 的次幂
    public static boolean isPowerOfTwo(Long N) {
        int j = 1;

        while (N > j) {
            j <<= 1;
        }

        return j == N;
    }
}
