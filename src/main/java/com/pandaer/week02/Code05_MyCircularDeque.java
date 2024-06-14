package com.pandaer.week02;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * <a href='https://leetcode.cn/problems/design-circular-deque/'>设计循环双端队列</a>
 */
public class Code05_MyCircularDeque {

    /**
     * 方法一：循环数组 实现双端队列
     * 思路：需要额外的三个变量，对头指针，对尾指针，以及记录大小的变量
     * 并规定 从头入队，队头指针向左移，从头出队，队头指针向右移
     * 而 从尾入队，就恰恰相反，对尾指针向右移，出队向左移
     * 时间复杂度：任何操作都是O(1)的操作
     * 空间复杂度：没有使用额外的空间，O(1)
     */
    static class MyCircularDeque {
        int[] elementData;
        int head,tail;
        int size;
        int limit;
        public MyCircularDeque(int k) {
            elementData = new int[k];
            head = 0;
            tail = 0;
            size = 0;
            limit = k;
        }

        public boolean insertFront(int value) {
            if (size == limit) {
                return false;
            }
            if (size == 0) {
              elementData[head] = value;
            }else {
                int index = (head - 1 + limit) % limit;
                elementData[index] = value;
                head = index;
            }
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (size == limit) {
                return false;
            }
            if (size == 0) {
                elementData[tail] = value;
            }else {
                int index = (tail + 1) % limit;
                elementData[index] = value;
                tail = index;
            }
            size++;
            return true;

        }

        public boolean deleteFront() {
            if (size == 0) {
                return false;
            }
            size--;
            if (size != 0) {
                head = (head + 1) % limit;
            }

            return true;
        }

        public boolean deleteLast() {
            if (size == 0) {
                return false;
            }
            size--;
            if (size != 0) {
                tail = (tail - 1 + limit) % limit;
            }
            return true;
        }

        public int getFront() {
            if (size == 0) {
                return -1;
            }
            return elementData[head];
        }

        public int getRear() {
            if (size == 0) {
                return -1;
            }
            return elementData[tail];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }
}
