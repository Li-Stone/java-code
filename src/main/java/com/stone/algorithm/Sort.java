package com.stone.algorithm;

/**
 * 排序
 *
 * @author Li-Stone
 */
public class Sort {
    /**
     * 快速排序
     *
     * @param arr  待排序数组
     * @param low  待排序子序列开始元素的下标
     * @param high 待排序子序列结果元素的下标
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int flag = arr[low], i = low, j = high;

            while (i < j) {
                while (i < j && arr[j] >= flag) {
                    --j;
                }
                if (i < j) {
                    arr[i] = arr[j];
                    ++i;
                }
                while (i < j && arr[i] < flag) {
                    ++i;
                }
                if (i < j) {
                    arr[j] = arr[i];
                    --j;
                }
            }
            arr[i] = flag;
            quickSort(arr, low, i - 1);
            quickSort(arr, i + 1, high);
        }
    }
}
