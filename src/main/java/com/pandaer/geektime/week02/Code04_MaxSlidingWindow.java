package com.pandaer.geektime.week02;

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
     * 方法二：单调队列
     * 思路：我们需要确定滑动窗口的左右边界，在这个滑动窗口的数据中维护一个单调队列，而我们需要的结果值，
     * 就是队头的值，即这个单调队列是单调递减
     * 时间复杂度：O(n)
     * 空间复杂度：O(k)
     */
    public int[] method02(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int j = 0,i= 1-k;j < nums.length;i++,j++) {
            if (i > 0 && !deque.isEmpty() && deque.peekFirst() == nums[i - 1]) {
                deque.removeFirst();
            }
            //保证队列单调
            while (!deque.isEmpty() && nums[j] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.add(nums[j]);
            if (i >= 0) {
                ans[index++] = deque.peek();
            }
        }
        return ans;
    }
}
