package org.xiyoulinux.各大排序;

/**
 * @Author: spider_hgyi
 * @Date: Create in 21:54 2018/4/3
 * @Modified By:
 * @Description:
 * 实现思想：
 * 1. 设数组的前 n-1 个数据已经有序，将第 n 个数据插入到前 n-1 个数据中合适的位置
 * 2. 对前 n-1 个数据进行二分搜索，找到应该插入的合适的位置（结束条件：start > end）
 * 3. 将待插入数据插入至 start 处，并将其他相应数据移动至相应位置
 *
 * 时间复杂度：O(n^2) 只是减少了比较次数
 * 空间复杂度：O(1) 常数级
 */
public class 二分法插入排序 {
    public static void main(String[] args) throws Exception {
        int[] array = {49, 38, 65, 97, 176, 213, 227, 49, 78, 34, 12, 164, 11, 18, 1};

        binaryInsert(array);

        for (int anArray : array) {
            System.out.println(anArray);
        }
    }

    public static void binaryInsert(int[] array) throws Exception {
        if (array == null || array.length <= 0) {
            throw new Exception("array is null");
        }

        if (array.length > 1) {
            for (int i = 1; i < array.length; i++) {
                // 记录待插入数字
                int temp = array[i];

                // 初始化二分搜索的 3 个指针
                int start = 0;
                int end = i - 1;
                int middle = (start + end) / 2;

                while (start <= end) {
                    if (temp < array[middle]) {
                        end = middle - 1;
                    } else {
                        start = middle + 1;
                    }

                    middle = (start + end) / 2;
                }

                for (int j = i - 1; j >= start; j--) {
                    array[j + 1] = array[j];
                }

                array[start] = temp;
            }
        }
    }
}