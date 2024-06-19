package com.pandaer.week03;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/longest-consecutive-sequence/?envType=study-plan-v2&envId=top-interview-150">最长连续序列</a>
 */
public class Code08_LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        return method01(nums);
    }


    /**
     * 解法一：排序 + 判断
     * 思路：先将数组排序，然后遍历数组判断是否连续
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(n)
     */
    public int method01(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            treeSet.add(num);
        }
        List<Integer> list = treeSet.stream().toList();
        int maxLen = 1;
        int left = 0;
        while (left < list.size()-1) {
            // 确认左边界
            if (list.get(left) + 1 != list.get(left+1)) {
                left++;
                continue;
            }
            int right = left + 1;

            while (right < list.size() - 1 && list.get(right) + 1 == list.get(right + 1)) {
                right++;
            }
            maxLen = Math.max(maxLen,right - left + 1);
            left = right + 1;

        }
        return maxLen;
    }



    /**
     * 解法二：枚举起点，判断后续数是否存在
     * 思路：先将这些数添加到一个HashSet中，然后遍历数组，假设一个数是序列的起点，然后判断集合中是否存在他的下一个数，以及下下个数
     * 为了减少无效的判断，只要这个数的-1存在集合中，那么以这个数开头的序列就一定不是最长的
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int method02(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int len = 1;
                int curNum = num;
                while (set.contains(curNum + 1)) {
                    len++;
                    curNum++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new Code08_LongestConsecutive().longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }


}
