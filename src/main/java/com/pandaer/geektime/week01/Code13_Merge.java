package com.pandaer.geektime.week01;



import java.util.*;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.cn/problems/merge-sorted-array/">合并两个有序数组</a>
 */
public class Code13_Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        method01(nums1,m,nums2,n);
    }

    /**
     * 解法一：双指针
     * 思路：从后往前填数据，在两个数组中找大的，谁大谁往后
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(1)
     */
    public void method01(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n -1;
        int last = m + n -1;

        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[last--] = nums1[index1--];
            }else {
                nums1[last--] = nums2[index2--];
            }
        }

        while (index1 >= 0) {
            nums1[last--] = nums1[index1--];
        }

        while (index2 >= 0) {
            nums1[last--] = nums2[index2--];
        }
    }




}
