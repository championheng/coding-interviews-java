package org.xiyoulinux.各大排序;

/**
 * @Author: spider_hgyi
 * @Date: Create in 19:49 2018/4/3
 * @Modified By:
 * @Description: 平均时间复杂度：O(n^2) 最差时间复杂度：O(n^2) 最好时间复杂度O(n)
 *
 * 关于空间复杂度：O(1)，只需要一个 temp 和 j，常量级空间复杂度
 */
public class 直接插入排序 {
    public static void main(String[] args) throws Exception {
        int[] array = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};

        insert(array);

        for (int anArray : array) {
            System.out.println(anArray);
        }
    }

    public static void insert(int[] array) throws Exception {
        if (array == null || array.length <= 0) {
            throw new Exception("array is null");
        }

        if (array.length > 1) {
            for (int i = 1; i < array.length; i++) {
                // 待插入数据
                int temp = array[i];
                int j = 0;
                // 将待插入数据与前面已经有序的数组进行比较
                for (j = i - 1; j >= 0; j--) {
                    if (temp < array[j]) {
                        array[j + 1] = array[j];
                    } else {
                        break;
                    }
                }

                array[j + 1] = temp;
            }
        }
    }
}