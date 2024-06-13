package com.pandaer.week02;

import java.util.*;

/**
 * <a href='https://leetcode.cn/problems/sliding-window-maximum/'>滑动窗口最大值</a>
 */
public class Code04_MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        return method01(nums,k);
    }

    /**
     * 解法一：优先级队列
     * 思路：建立大根堆，然后先加入k个元素，记录一次最大值，然后遍历数组，每加入一个数就多一个最大值
     * 时间复杂度：O(klogk + (n-k)*(k+logk)) 如果k接近n,nlogn,如果k接近1，n
     * 空间复杂度：O(k)
     * 超出时间限制
     */
    public int[] method01(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int index = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i<k;i++) {
            priorityQueue.add(nums[i]);
        }
        ans[index++] = priorityQueue.peek();

        for (int i = k; i< nums.length;i++ ) {
            priorityQueue.remove(nums[i - k]);
            priorityQueue.add(nums[i]);
            ans[index++] = priorityQueue.peek();
        }
        return ans;
    }


    /**
     * 方法二：单队列
     * 思路：先加入k个队列，不过在加入过程中，会不断地判断加入的值是否比当前最大值还要大，并更新最大值
     * 时间复杂度：
     * 空间复杂度：
     * @param nums
     * @param k
     * @return
     */
    public int[] method02(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int index = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        int tempMax = nums[0];
        for(int i = 0; i<k;i++) {
            int value = nums[i];
            queue.add(value);
            tempMax = Math.max(tempMax,value);
        }
        ans[index] = tempMax;
        for (int i = k; i< nums.length;i++) {
            queue.poll();
            queue.add(nums[i]);

        }

        return ans;
    }
}
