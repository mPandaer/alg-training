package com.pandaer.geektime.week01;


import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list/">反转链表</a>
 */
public class Code06_ReverseList {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        return method01(head);
    }

    /**
     * 方法一：头插法的变形
     * 思路：解题的思路很简单，我们可以想象我们要构建一个新的链表，只不过构建新的链表中的元素是旧链表中的
     * 而且增加元素的方法从常见的尾插变成了头插。当我们将全部的元素从旧的链表中搬运到新的链表中的时候，链表的反转也就完成了。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    public ListNode method01(ListNode head) {
        ListNode newHead = null;
        if (head == null) {
            return null;
        }
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }


    /**
     * 方法一：递归的方法
     * 思路：递归问题 ==> 拆分成多个同等结构的小规模问题，一直拆解，直到小规模问题很容易解决，这种我们称为base case
     * 方法的定义：将参数的链表反转过来,递归问题，函数自己调用自己，必须保证参数的规模要减小
     * 时间复杂度：O(n)
     * 空间复杂度：O(n) 调用栈的额外空间占用
     * @param head
     * @return
     */
    public ListNode method02(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = method02(next);
        next.next = head;
        head.next = null;
        return newHead;
    }



}
