package com.pandaer.geektime.week01;

import java.util.HashMap;
import java.util.Map;

/**
 * 热身题
 */
public class Code01_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        return method01(nums,target);
    }

    /**
     * 方法一： 暴力遍历就好
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] method01(int[] nums, int target) {
        for (int i = 0; i < nums.length;i++) {
            for (int j = i + 1;j<nums.length;j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }


    /**
     * 方法二：缓存遍历结果，用空间换时间
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] method02(int[] nums, int target) {
        // key element, value index
        Map<Integer,Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!indexMap.containsKey(target - nums[i])) {
                indexMap.put(nums[i],i);
                continue;
            }
            return new int[]{i,indexMap.get(target-nums[i])};

        }
        return null;
    }
}
