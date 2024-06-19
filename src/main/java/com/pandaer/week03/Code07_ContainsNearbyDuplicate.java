package com.pandaer.week03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/contains-duplicate-ii/description/?envType=study-plan-v2&envId=top-interview-150">存在重复元素 II</a>
 */
public class Code07_ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        return method01(nums,k);
    }


    /**
     * 解法一：HashMap + 遍历
     * 思路：遍历nums数组时，如果Map中不存在这个值就直接加入即可，如果存在这个就需要判断 索引之间的差距是否小于给定的值，如果不小于就需要更新值以及对应的索引
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public boolean method01(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i],i);
                continue;
            }
            int res = i - map.get(nums[i]);
            if (res <= k) {
                return true;
            }
            map.put(nums[i],i);
        }
        return false;

    }


}
