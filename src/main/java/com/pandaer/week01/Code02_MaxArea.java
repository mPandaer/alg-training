package com.pandaer.week01;


import org.junit.jupiter.api.Test;

/**
 * <a href="https://leetcode.cn/problems/container-with-most-water/description/">盛最多水的容器</a>
 */
public class Code02_MaxArea {
    public int maxArea(int[] height) {
        return method01(height);
    }

    /**
     * 方法一： 暴力解
     * 思路：求出每个端点组成的容器的面积，再从里面找最大值即可
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 提交代码失败，超出时间限制
     */
    public int method01(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j<height.length;j++) {
                int curArea = (j-i) * Math.min(height[i],height[j]);
                maxArea = Math.max(maxArea,curArea);
            }
        }
        return maxArea;
    }

    /**
     * 方法二： 双指针解法
     * 思路：解法一的时间复杂度过大，所以没有通过代码提交，于是我们的策略就是降低时间复杂度，比O(n^2)小的就两个
     * 一个是 O(n) 一个是 O(logN)，O(n)的思路我有，
     * 解法一的长度在渐渐扩大，而高度也有可能扩大，导致不知道面积的增大是那个因素引起的，于是我们可以控制变量
     * 这里最好控制的变量，就是长度了，我们可以一开始就让长度最大，然后渐渐缩小，如果在缩小的过程中，面积扩大了，那么就一定是高度导致的
     * 有了这个思路，那么我们要寻找的最大的面积，一定在这群面积扩大了的情况里。
     * 而要想面积扩大，就一定要让较小的高度变大，所以我们需要确定到底是左边的高度较小，还是右边的高度较小
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int method02(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int curArea = (right - left) * Math.min(height[left],height[right]);
            maxArea = Math.max(maxArea,curArea);
            //确定移动方向
            int leftVal = height[left];
            int rightVal = height[right];
            if (leftVal < rightVal) {
                for (left = left + 1; left < right;left++) {
                    if (height[left] > leftVal) {
                        break;
                    }
                }
            }else {
                for (right = right -1; right > left; right--) {
                    if (height[right] > rightVal) {
                        break;
                    }
                }
            }
        }
        return maxArea;
    }

    @Test
    public void test() {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(method02(arr));
    }



}
