package org.xiyoulinux.二分搜索的应用;

/**
 * @Author: spider_hgyi
 * @Date: Create in 19:03 2018/3/27
 * @Modified By:
 * @Description:
 * 实现思想: 二分查找的变种（设置start、end）
 *
 * 1. 旋转数组的特点：start元素绝对大于等于end元素
 * 2. 局部递增，point = （start + end） / 2，point所指元素比start元素大，则属于前半序列数组；
 *  point所指元素比end元素小，则属于后半序列数组
 * 3. 属于前半序列数组则start = point，属于后半序列数组则end = point
 * 4. 循环不断逼近，当两个指针相遇时，end指针所指元素为最小值
 *
 * 实现思想是以旋转数组的特点为基础进行分析实现。
 *
 * 特殊情况:
 * 1. 数组为空 | 数组的长度为1
 * 2. 数组本身没有旋转，排序数组只是旋转数组的特殊情况（start元素大于end元素的假设则不成立）
 * 3. 数组中有相等元素（除start、point、end元素相同外会造成无法判断point所指元素属于哪一个序列外，
 *  其他情况无影响。）解决方法为顺序查找！
 */

public class 旋转数组的最小数字 {
    public static void main(String[] args) throws Exception {
        int[] array = {4, 5, 6, 7, 8, 9, 0, 1, 2, 3};

        int min = min(array);

        System.out.println(min);
    }

    // 寻找数组的最小值
    public static int min(int[] array) throws Exception {
        if (array.length <= 0) {
            throw new Exception("array is null");
        }

        if (array.length == 1) {
            return array[0];
        }

        int start = 0;
        int end = array.length - 1;
        // 初始化是为了应对特殊情况2的发生
        int point = start;

        while (array[start] >= array[end]) {
            point = (start + end) / 2;

            if (end - start == 1) {
                return array[end];
            }

            // 当start、end、point元素相等时进行顺序查找
            if (array[start] == array[end] && array[start] == array[point]) {
                return minInOrder(array);
            }

            if (array[point] >= array[start]) {
                start = point;
            }

            if (array[point] <= array[end]) {
                end = point;
            }
        }

        return array[point];
    }

    // 进行顺序查找
    public static int minInOrder(int[] array) {
        int result = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < result) {
                result = array[i];
            }
        }

        return result;
    }
}