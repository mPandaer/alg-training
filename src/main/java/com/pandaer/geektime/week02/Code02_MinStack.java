package com.pandaer.geektime.week02;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href='https://leetcode.cn/problems/min-stack/'>最小栈</a>
 */
public class Code02_MinStack {


    /**
     * 解法一：双栈
     * 思路：为了让获取最小元素为常数操作，我们可以维护一个数据栈，一个最小栈，最小栈是相对于数据栈的整体的最小值
     * 时间复杂度：O(1)
     * 空间复杂度：O(n)
     */
    static class MinStack {
        Deque<Integer> dataStack = new LinkedList<>();
        Deque<Integer> minStack = new LinkedList<>();
        public MinStack() {

        }

        public void push(int val) {
            dataStack.push(val);
            if (minStack.isEmpty()) {
                minStack.push(val);
                return;
            }
            int min = Math.min(val,minStack.peek());
            minStack.push(min);
        }

        public void pop() {
            dataStack.pop();
            minStack.pop();
        }

        public int top() {
            return dataStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
