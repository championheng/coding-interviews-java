package org.xiyoulinux.二分搜索的应用;

import java.util.Scanner;

/**
 * @Author: spider_hgyi
 * @Date: Create in 21:22 2018/3/26
 * @Modified By:
 * @Description:
 * 实现思想：旋转数组的变种（二分查找）
 *
 * 1. 通过二分搜索先找到旋转数组中的分裂点，即最小数字。（见“旋转数组的最小数字”代码实现）（时间复杂度：O(logn)）
 * 2. 找到分裂点后，可将数组分为前后两个分别递增的数组
 * 3. 判断所要查找的数字是在哪一段递增数组中
 * 4. 对此段递增数组进行二分查找（时间复杂度：O(logn)）
 */
public class 局部递增数组二分搜索 {
    public static void main(String[] args) throws Exception {
        int[] array = {4, 5, 6, 7, 8, 9, 0, 1, 2, 3};
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int find = scanner.nextInt();
            boolean flag = binarySearch(array, find);

            System.out.println(flag);
        }
    }

    // 对旋转数组的二分搜索
    public static boolean binarySearch(int array[], int find) throws Exception {
        if (array.length <= 0) {
            throw new Exception("array is null");
        }

        if (array.length == 1) {
            return find == array[0];
        }

        int spiltPoint = spiltPoint(array);

        return binarySearch(array, spiltPoint, find);
    }

    // 二分查找旋转数组分裂点（最大值所在索引）
    public static int spiltPoint(int[] array) {
        int start = 0;
        int end = array.length - 1;
        // 数组原本有序
        int midPoint = start;

        while (array[start] >= array[end]) {
            // 找到分裂点（旋转数组中最大的数）
            if (end - start == 1) {
                midPoint = start;
                break;
            }

            midPoint = (start + end) / 2;
            // 特殊情况（start、midPoint、end元素相等则进行顺序查找）
            if (array[start] == array[midPoint] && array[midPoint] == array[end]) {
                midPoint = spiltPointOrder(array);
                break;
            }

            if (array[midPoint] >= array[start]) {
                start = midPoint;
            }

            if (array[midPoint] <= array[end]) {
                end = midPoint;
            }
        }

        return midPoint;
    }

    // 顺序查找分裂点（最大数所在索引）
    public static int spiltPointOrder(int[] array) {
        int result = 0;
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] <= result) {
                result = array[i];
                index = i;
            }
        }

        return index - 1;
    }

    // 普通的二分搜索
    public static boolean binarySearch(int[] array, int spiltPoint, int find) {
        int start = 0;
        int end = array.length - 1;

        // 确定待查值属于哪一部分的递增序列
        if (find >= array[start] && find <= array[spiltPoint]) {
            end = spiltPoint;
        } else {
            start = spiltPoint + 1;
        }

        int midPoint = (start + end) / 2;

        // 二分搜索
        while (find != array[midPoint]) {
            if (end - start == 1) {
                return array[start] == find || array[end] == find;
            }

            if (find < array[midPoint]) {
                end = midPoint;
            }

            if (find > array[midPoint]) {
                start = midPoint;
            }

            midPoint = (start + end) / 2;
        }

        return true;
    }
}