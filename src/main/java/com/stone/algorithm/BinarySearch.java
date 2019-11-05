package com.stone.algorithm;

/**
 * 二分查找相关代码示例
 *
 * @author Li-Stone
 */
public class BinarySearch {

    /**
     * @param num    原始值
     * @param factor 允许计算结果的误差范围
     * @return
     */
    public static float square(int num, float factor) {
        if (num == 0 || num == 1) {
            return num;
        }
        float result = 1;
        for (int i = 1; i <= num / 2; ++i) {
            // 结果是整型
            if (i * i == num) {
                return i;
            }
            // 结果是浮点型时用二分查找，根据误差范围来限制循环次数
            else if (i * i < num && (i + 1) * (i + 1) > num) {
                float low = i;
                float high = (i + 1);
                float mid = (low + high) / 2;
                while (mid * mid != num && ((mid - factor) * (mid - factor) > num || (mid + factor) * (mid + factor) < num)) {
                    while (mid * mid < num) {
                        low = mid;
                        mid = (low + high) / 2;
                    }
                    while (mid * mid > num) {
                        high = mid;
                        mid = (low + mid) / 2;
                    }
                }
                return mid;
            }
        }
        return result;
    }
}
