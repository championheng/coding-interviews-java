package org.xiyoulinux.数组;

/**
 * @Author: spider_hgyi
 * @Date: Create in 19:38 2018/3/29
 * @Modified By:
 * @Description: 使用哈希思想，时间复杂度为O(n)，空间复杂度为O(n)的方法不再实现
 */
public class 数组中重复的数字 {
    public static void main(String[] args) throws Exception {
//        int[] array1 = {2, 3, 1, 0, 2, 5, 3};
          int[] array2 = {2, 3, 5, 4, 3, 2, 6, 7};
//        int number = duplicate(array1);
          int number = duplicate(array2);

        System.out.println(number);
    }

    /**
     * 时间复杂度：O(n)、空间复杂度：O(1)
     * 注：尽管有双重循环，但每个数字最多只要交换两次就能找到属于它自己的位置
     *
     * 测试用例：{2, 3, 1, 0, 2, 5, 3}
     *
     * 实现思想：i 为数组下标
     * 1. 比较 array[i] 与 i 是否相等
     * 2. 相等的话则 i++，否则比较 array[i] 与 array[array[i]]
     * 3. array[i] == array[array[i]] 找到重复值
     * 4. array[i] != array[array[i]] 交换两个值的位置
     * 5. 重复以上步骤
     */
//    public static int duplicate(int[] array) throws Exception {
//        if (array == null) {
//            throw new Exception("array is null");
//        }
//
//        if (array.length <= 0) {
//            throw new Exception("array's length <= 0");
//        }
//
//        for (int anArray : array) {
//            if (anArray < 0 || anArray > array.length - 1) {
//                throw new Exception("array is illegal");
//            }
//        }
//
//        for (int i = 0; i < array.length; ++i) {
//            while (array[i] != i) {
//                if (array[i] == array[array[i]]) {
//                    return array[i];
//                }
//
//                int temp = array[i];
//                array[i] = array[temp];
//                array[temp] = temp;
//            }
//        }
//
//        return -1;
//    }

    /**
     * 时间复杂度：O(nlogn)、空间复杂度：O(1)
     * 注：二分查找的时间复杂度为O(logn)，每次二分后还要统计在此二分区间中的数值个数，时间复杂度为O(n)。
     *
     * 测试用例：{2, 3, 5, 4, 3, 2, 6, 7}
     *
     * 实现思想：二分查找的应用
     * start = 1; end = array.length - 1;
     * 1. 找到数组中数值范围的中间值 middle = (start + end) / 2
     * 2. 统计数组中出现在 start-middle 范围中数值的个数 count，如果 count > middle - start + 1
     *  则说明 start-middle 中有重复数字，否则 middle+1-end 中有重复数字
     * 3. 重复步骤 2，直到 start = end 时，此时count > 1，则返回start
     *
     * 缺点：不能找到测试用例中的数值2，当二分区间确定为 1-2 时，我们不能确定区间中是每个数字出现
     *  1 次，还是数字 2 出现了 2 次，count 并没有大于区间范围，程序判断无重复数字，出现误判。
     */
    public static int duplicate(int[] array) throws Exception {
        if (array == null) {
            throw new Exception("array is null");
        }

        if (array.length <= 0) {
            throw new Exception("array's length <= 0");
        }

        for (int anArray : array) {
            if (anArray < 1 || anArray > array.length - 1) {
                throw new Exception("array is illegal");
            }
        }

        int start = 1;
        int end = array.length - 1;
        int middle = (start + end) / 2;

        while (start <= end) {
            int count = countRange(array, start, middle);
            if (start == end) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }

            if (count > middle - start + 1) {
                end = middle;
                middle = (start + end) / 2;
            } else {
                start = middle + 1;
                middle = (start + end) / 2;
            }
        }

        return -1;
    }

    public static int countRange(int[] array, int start, int middle) {
        int count = 0;

        for (int anArray : array) {
            if (anArray <= middle && anArray >= start) {
                count++;
            }
        }

        return count;
    }
}