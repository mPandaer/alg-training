package com.pandaer.week02;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href='https://leetcode.cn/problems/largest-rectangle-in-histogram/'>柱状图中最大的矩形</a>
 */
public class Code03_largestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        return method03(heights);
    }

    /**
     * 解法一：先确定宽度，然后枚举全部的面积，从最大的面积中选出一个
     * 思路：选定一个为左边界，不断移动右边界，求解面积
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 超出时间限制
     */
    public int method01(int[] heights) {
        int maxArea = 0;
        for (int left = 0; left < heights.length; left++) {
            int minHeight = heights[left];
            for (int right = left; right < heights.length; right++) {
                minHeight = Math.min(minHeight, heights[right]);
                int curArea = minHeight * (right - left + 1);
                maxArea = Math.max(curArea, maxArea);
            }
        }
        return maxArea;
    }


    /**
     * 解法二 先确定高度，然后向左以及向右扩展宽度，枚举全部的面积
     * 思路：遍历高度，先定下一个高度，先左以及向右扩展的时候，只要高度比定下的这个高度高，就可以扩展，否则就可以计算面积了。
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 超出时间限制
     */
    public int method02(int[] heights) {
        int area = 0;
        for (int i = 0; i < heights.length; i++) {
            int curHeight = heights[i];
            int left = i;
            while (left - 1 >= 0 && heights[left - 1] >= curHeight) {
                left--;
            }

            int right = i;
            while (right + 1 < heights.length && heights[right + 1] >= curHeight) {
                right++;
            }

            int curArea = curHeight * (right - left + 1);
            area = Math.max(curArea, area);

        }

        return area;
    }


    /**
     * 方法三：方法三是基于方法二的优化版本 单调栈
     * 思路：在方法二中，我们的思路是先确定高度，然后通过不断地扩展左右边界确定最大的宽度，将每个高度下的最大面积都计算完后，就可以从里面取出最大值，就是答案
     * 这是方法二的思路，但是这个方法不能通过测试，所以我们必须降低时间复杂度，最简单的方法就是空间换时间。
     * 通过仔细仔细的观察，我们发现了一个规律，那就是在确定某个高度的时候，如果后续有个有柱子比他高，那么这个柱子的某个边界就确定好了，举个例子
     * 比如 2，5，6，2，当我们在确定5的左右边界的时候，其实6的左右边界也以及确定了，对于5而言他的最大面积就是 5 * 2 = 10，对于6而言，由于左边是5，所以最大面积就是 6 * 1 = 6
     * <p>
     * 所以方法三的思路是这样的：我们需要维护一个单调栈，我们遍历高度，将高度的索引添加进栈中，知道添加的索引对应的高度比栈顶小，
     * 因为单调栈天然确定了左边界，而当添加的索引对应的高度比栈顶小的时候，栈顶元素的右边界也确定好了。这个时候 宽度 = 要加入的索引 - 栈顶索引 高度 = 栈顶元素对应的高度
     * 这是一次处理，如果当前的栈顶还是比要加入的高，那么继续出栈重复上述操作，如果高度遍历完之后，栈并不为空，比如 1，2，3，4，4，5，
     * 我们只需要出栈，并判断新的栈顶是否等于它，如果等于它就一直弹，然后计算面积
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * 算法不算最优
     */
    public int method03(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        int n = heights.length;
        for (int i = 0; i<= n;i++) {
            int curHeight = i == n ? 0 : heights[i];
            while (!stack.isEmpty() && curHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;

    }

    public static void main(String[] args) {
        Code03_largestRectangleArea code03LargestRectangleArea = new Code03_largestRectangleArea();
        System.out.println(code03LargestRectangleArea.method03(new int[]{4,2,0,3,2,5}));
    }
}
