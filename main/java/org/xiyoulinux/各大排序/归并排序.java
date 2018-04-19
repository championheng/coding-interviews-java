package org.xiyoulinux.各大排序;

/**
 * @Author: spider_hgyi
 * @Date: Create in 23:25 2018/4/7
 * @Modified By:
 * @Description:
 * 自顶向下递归的实现思路：
 * 1. 将数组进行左右递归拆分，也就是将原数组分割成两个子序列、四个子序列... ...直到每个子序列中
 * 只有一个元素，则单个元素有序
 * 2. 对分割的子序列进行两两合并（递归回退），此时需要一个辅助数组，保存合并后的序列，然后对原序列进行刷新
 * 3. 递归结束、数组有序
 *
 * 时间复杂度：分割序列需要 O(logn)，合并序列需要 O(n)，时间复杂度 O(nlogn)
 * 空间复杂度：需要一个辅助数组，空间复杂度 O(n)
 *
 * 自底向上循环的实现思路：
 * 1. 将数组进行划分，分割子序列，子序列的初始长度为 1
 * 2. 确定每个序列的 start、middle 与 end，将子序列进行排序（合并）
 * 3. 步骤 2 在合并的时候，需要一个辅助数组，合并完成后需对原数组进行刷新
 * 4. 当分割的子序列的长度大于等于原序列的时候，排序完成
 *
 * 时间复杂度：1. 确定序列长度（最外层 for 循环需要 O(logn)）
 *            2. 划分序列（中间 for 循环 需要 O(n)）
 *            3. 合并子序列（最里层 for 循环）需要 O(n)
 *            最终时间复杂度：O(nlogn) + O(n) = O(nlogn)
 *
 * 空间复杂度：需要一个辅助数组，空间复杂度 O(n)
 */
public class 归并排序 {
    public static void main(String[] args) throws Exception {
        int[] array = {2, 4, 7, 5, 8, 1, 3, 6, 9};

        mergeSort(array);

        for (int anArray : array) {
            System.out.println(anArray);
        }
    }

    // 自顶向下递归进行实现
//    public static void mergeSort(int[] array) throws Exception {
//        if (array == null || array.length <= 0) {
//            throw new Exception("array is null");
//        }
//
//        int start = 0;
//        int end = array.length - 1;
//
//        // 设置一个辅助数组
//        int[] temp = new int[array.length];
//
//        mergeSort(array, start, end, temp);
//    }
//
//    public static void mergeSort(int[] array, int start, int end, int[] temp) {
//        // 递归拆分的条件：start < end
//        if (start < end) {
//            // 对数组进行拆分
//            int middle = (start + end) / 2;
//            mergeSort(array, start, middle, temp);
//            mergeSort(array, middle + 1, end, temp);
//
//            // 对数组进行合并
//            int k = 0;
//            int i = 0;
//            int j = 0;
//            for (i = start, j = middle + 1, k = start; i <= middle && j <= end; k++) {
//                if (array[i] <= array[j]) {
//                    temp[k] = array[i];
//                    i++;
//                } else {
//                    temp[k] = array[j];
//                    j++;
//                }
//            }
//
//            while (i <= middle) {
//                temp[k++] = array[i];
//                i++;
//            }
//
//            while (j <= end) {
//                temp[k++] = array[j];
//                j++;
//            }
//
//            // 更新原数组
//            for (i = start, k = start; i <= end; i++, k++) {
//                array[i] = temp[k];
//            }
//        }
//    }

    // 自底向上循环进行实现
    public static void mergeSort(int[] array) {
        // 确定数组的长度
        int length = array.length;
        // 辅助数组
        int[] temp = new int[length];

        // 子序列的长度，当子序列的长度 >= 原序列的时候排序完成
        for (int i = 1; i < length; i *= 2) {
            // 确定子序列中的 start 与 end
            for (int start = 0; start < length; start += i) {
                int end = start + i - 1;
                if (end >= length) {
                    end = length - 1;
                }

                int middle = (start + end) / 2;

                int k = 0;
                int p = 0;
                int q = 0;
                for (p = start, q = middle + 1, k = start; p <= middle && q <= end; k++) {
                    if (array[p] <= array[q]) {
                        temp[k] = array[p];
                        p++;
                    } else {
                        temp[k] = array[q];
                        q++;
                    }
                }

                while (p <= middle) {
                    temp[k++] = array[p];
                    p++;
                }

                while (q <= end) {
                    temp[k++] = array[q];
                    q++;
                }

                k = start;
                for (int t = start; t <= end; t++) {
                    array[t] = temp[k++];
                }
            }
        }
    }
}