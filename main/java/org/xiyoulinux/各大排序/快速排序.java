package org.xiyoulinux.各大排序;

/**
 * @Author: spider_hgyi
 * @Date: Create in 9:51 2018/4/2
 * @Modified By:
 * @Description: 平均时间复杂度：O(nlogn) 最坏时间复杂度：O(n^2) 空间复杂度：O(logn)
 *
 * 关于空间复杂度：每次递归都需要分配 3 个局部变量，递归深度为logn，空间复杂度：O(logn)
 */
public class 快速排序 {
    public static void main(String[] args) throws Exception {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        qSort(array);

        for (int anArray : array) {
            System.out.println(anArray);
        }
    }

    public static void qSort(int[] array) throws Exception {
        if (array == null || array.length <= 0) {
            throw new Exception("input is null");
        }

        // 设置前后指针
        int start = 0;
        int end = array.length - 1;

        qSort(array, start, end);
    }

    public static void qSort(int[] array, int start, int end) {
        // 满足 start < end 进行递归
        if (start < end) {
            int i = start;
            int j = end;
            int temp = array[i];

            // 当 i == j 的时候一趟快速排序完成
            while (i < j) {
                while (i < j && array[j] >= temp) {
                    --j;
                }
                array[i] = array[j];

                while (i < j && array[i] < temp) {
                    ++i;
                }
                array[j] = array[i];
            }

            array[i] = temp;
            qSort(array, start, i - 1);
            qSort(array, i + 1, end);
        }
    }
}