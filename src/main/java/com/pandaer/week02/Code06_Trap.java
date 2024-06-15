package com.pandaer.week02;

/**
 * <a href='https://leetcode.cn/problems/trapping-rain-water/'>接雨水</a>
 */
public class Code06_Trap {
    public int trap(int[] height) {
        return method01(height);
    }


    /**
     * 解法一：暴力解
     * 思路：我们可以计算每个宽度为1的柱子上，能够积累多少水，由于宽度已经定死了，于是我们只需要寻找大于当前柱子高度的最大较小柱子，
     * 过程是这样的，以当前柱子为中心，向左寻找最大的柱子，向右寻找最大的柱子，取里面的较小值，然后 由这个较小值 - 当前柱子的高度
     * 即当前这个柱子上可以积累的水量 因为宽度为1 所以不需要乘以宽度。
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    public int method01(int[] height) {
        int totalWater = 0;
        int n = height.length;

        for (int i = 0; i< n;i++) {
            int leftMax = height[i];
            int rightMax = height[i];

            for (int j = 0; j < i; j++) {
                leftMax = Math.max(height[j],leftMax);
            }
            for (int j = i + 1;j< n; j++) {
                rightMax = Math.max(height[j],rightMax);
            }

            totalWater += Math.min(leftMax,rightMax) - height[i];
        }
        return totalWater;
    }


    /**
     * 解法二：暂存左边界和右边界 （空间换时间策略）
     * 思路：针对解法一，我们发现在一个大的循环里面，我们不得不每次都寻找柱子的左边最大高度以及右边最大高度，而每次记录的结果还不能复用
     * 如果我们可以用一些数组将这些最大高度提前记录好，不就可以减少时间复杂度了吗？
     * 时间复杂度：O(n)
     * 空间复杂度：O(2n) = O(n)
     */
    public int method02(int[] height) {
        int totalWater = 0;
        int n = height.length;
        int[] leftMaxArr = new int[n];
        int[] rightMaxArr = new int[n];

        //记录每个柱子左边界
        leftMaxArr[0] = height[0];
        for (int i = 1; i<n;i++) {
            leftMaxArr[i] = Math.max(leftMaxArr[i-1],height[i]);
        }
        //记录每个柱子的右边界
        rightMaxArr[n - 1] = height[n-1];
        for (int i = n -2;i>=0; i--) {
            rightMaxArr[i] = Math.max(rightMaxArr[i+1],height[i]);
        }

        //计算进水量
        for (int i = 0; i< n;i++) {
            totalWater += Math.min(leftMaxArr[i],rightMaxArr[i]) - height[i];
        }
        return totalWater;
    }

    /**
     * 解法三：双指针 优化解法二的空间复杂度
     * 思路：针对解法二，我们提前计算了每个柱子的最大左高度以及最大右高度并缓存起来，等待后面计算面积时使用。但是在计算每个柱子的左最大高度时，
     * 发现了一个规律，那就是当前柱子的左最大高度 = 上一个柱子的左最大高度与自己高度的较大者。那么解法三的思路就是这样的，利用双指针，从两边往中间
     * 移动，仍然是计算每个柱子的积累水量。双指针的做法精妙的地方在于它并没有一定要要确定好最大左高度以及最大右高度才做计算
     * 而是可以确定出影响当前柱子的最大高度，也就是通过左右指针，可以确定当前柱子的最大高度的较小值是谁，
     * 但是并不一定要确定当前最大柱子的最大高度的较大值是谁 因为积水量取决于较小值。
     * 时间复杂度：(n)
     * 空间复杂度：(1)
     */
    public int method03(int[] height) {
        int totalWater = 0;
        int n = height.length;
        int left = 0,right = n-1;
        int leftMax = 0,rightMax = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] < leftMax) {
                    totalWater += leftMax - height[left];
                }else {
                    leftMax = height[left];
                }
                left++;
            }else {
                if (height[right] < rightMax) {
                    totalWater += rightMax - height[right];
                }else {
                    rightMax = height[right];
                }
                right--;
            }
        }

        return totalWater;

    }

}
