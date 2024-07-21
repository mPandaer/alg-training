package com.pandaer.geektime.week01;



import java.util.List;
import java.util.TreeSet;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/">删除有序数组中的重复项</a>
 */
public class Code11_RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        return method01(nums);
    }

    /**
     * 解法一：有序表
     * 思路：使用基于有序表的Set，将元素从nums添加到Set中即可
     * 时间复杂度：O(n)
     * 空间复杂度：O(k)
     * @param nums
     * @return
     */
    public int method01(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        List<Integer> list = set.stream().toList();
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return list.size();
    }

    /**
     * 解法二：双指针
     * 思路：类似这样的问题，处理后的数组比原数组的长度小，就可以使用双指针 + 逻辑数组，一个指针代表原数组的起点，另外一个指针代表新数组的起点，但是新旧数组用的都是同一个内存空间
     * 新数组只能存放不重复的数据，旧数组遇到重复的数据就跳过
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int method02(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        //第一个肯定是不会重复的
        int k = 1;
        for (int i = 1; i< nums.length;i++) {
            if (nums[i] == nums[i-1]) {
                continue;
            }
            nums[k++] = nums[i];
        }

        return k;
    }


}
