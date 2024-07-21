package com.pandaer.geektime.week01;


/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list/">反转链表</a>
 */
public class Code07_SwapPairs {


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

    public ListNode swapPairs(ListNode head) {
        return method01(head);
    }


    /**
     * 方法一：确定要交换的节点，循环往返下去
     * 思路：利用双指针确定好要交换的边界，并记录好下一次要交换的第一个元素，然后交换本次，并拼接回去,可以通过一个虚拟节点将特例也纳入常规中
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    public ListNode method01(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fake = new ListNode(-1);
        fake.next = head;
        head = fake;
        ListNode cur = head;
        while (cur.next != null && cur.next.next != null) {
            ListNode next = cur.next.next.next;
            ListNode left = cur.next;
            ListNode right = cur.next.next;
            right.next = left;
            left.next = next;
            cur.next = right;
            cur = left;
        }
        return head.next;
    }



}
