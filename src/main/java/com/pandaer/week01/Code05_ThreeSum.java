package com.pandaer.week01;


import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/3sum/">三数之和</a>
 */
public class Code05_ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        return method01(nums);
    }

    /**
     * 方法一 暴力解
     * 思路：很简单，既然从nums中找3个数，并让其之和为零，那就暴力解
     * 时间复杂度：O(n^3)
     * 空间复杂度：O(1)
     * 提交代码未通过，超出时间限制
     */
    public List<List<Integer>> method01(int[] nums) {
        Set<List<Integer>> list = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j<nums.length;j++) {
                for (int k = j + 1; k<nums.length;k++) {
                    if (nums[i] + nums[k] + nums[j] == 0) {
                        List<Integer> res = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(res);
                        list.add(res);
                    }
                }
            }
        }
        return list.stream().toList();
    }






}
