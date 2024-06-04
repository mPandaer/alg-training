package com.pandaer.week01;


import org.junit.jupiter.api.Test;

/**
 * <a href="https://leetcode.cn/problems/move-zeroes/">移动零</a>
 */
public class Code03_MoveZeroes {

    public void moveZeroes(int[] nums) {
        method01(nums);
    }

    /**
     * 方法一
     * 思路：仍然是双指针思想，一个指针表示旧数组中的索引，一个指针表示新数组的索引
     * 将旧数组中不为零的数拷贝到新数组中，只不过旧数组和新数组是逻辑上的，实际上用的还是同一个数组的空间
     * 之所以可以这样，是因为新数组的长度一定<=旧数组的长度，而新数组和旧数组指向的内存空间都是原来旧数组的空间
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public void method01(int[] nums) {
        int oldIndex = 0;
        int newIndex = 0;
        for (;oldIndex < nums.length;oldIndex++) {
            if (nums[oldIndex] != 0) {
                nums[newIndex++] = nums[oldIndex];
            }
        }
        //置零操作
        while (newIndex < nums.length) {
            nums[newIndex] = 0;
            newIndex++;
        }
    }




}
