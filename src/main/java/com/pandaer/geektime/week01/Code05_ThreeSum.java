package com.pandaer.geektime.week01;


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

    /**
     * 方法二 排序 + 双指针
     * 思路：题目要求我们寻找 a + b + c = 0 的数，我们完全可以先定死一个数，然后从剩下的数组中找出两个数使其 a + b = -c
     * 为了进一步缩小范围，我们可以先对数组进行排序，如果我们定死的数为正数，那么就不可能为零。即结果为空
     * 如果我们定死的数为负数，那么就需要利用双指针寻找其他的两个数，如果两个数的和 大于 c的绝对值，那么需要减小，直到双指针相撞，同理如果两个数的和小于c的绝对值，那么需要增大，直到双指针相撞
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    public List<List<Integer>> method02(int[] nums) {
        Set<List<Integer>> list = new HashSet<>();
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i<nums.length;i++) {
            if (nums[i] > 0) {
                break;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] > 0) {
                    right--;
                }else if (nums[left] + nums[right] + nums[i] < 0) {
                    left++;
                }else {
                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //移动指针，有待考虑
                    left++;
                    right--;
                }
            }
        }
        return list.stream().toList();
    }






}
