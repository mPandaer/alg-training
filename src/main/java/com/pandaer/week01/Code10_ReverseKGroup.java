package com.pandaer.week01;


import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/reverse-nodes-in-k-group/">K个一组翻转链表</a>
 */
public class Code10_ReverseKGroup {


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

    public ListNode reverseKGroup(ListNode head, int k) {
        return method01(head, k);
    }

    /**
     * 方法一：先确定要反转的边界 ==> 执行反转 ==> 拼接
     * 思路：我们先利用虚拟节点，将特例纳入常规，确定一组的边界，记录下一组的开始，执行这一组的反转，拼接回去
     * 时间复杂度：
     * 空间复杂度：
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode method01(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        //创建虚拟节点
        ListNode fake = new ListNode(-1);
        fake.next = head;
        head = fake;

        ListNode cur = head;
        while (cur != null) {
            //确定边界
            ListNode left = cur.next;
            ListNode right = cur;
            boolean isK = true;
            for (int i = 0; i < k; i++) {
                right = right.next;
                if (right == null) {
                    isK = false;
                    break;
                }
            }
            //这一组是否有K个
            if (!isK) {
                break;
            }
            //记录下一组的起点
            ListNode next = right.next;
            //执行反转
            cur.next = reverse(left, right);
            left.next = next;
            cur = left;
        }
        return head.next;
    }

    private ListNode reverse(ListNode left, ListNode right) {
        ListNode newHead = null;
        while (left != right) {
            ListNode next = left.next;
            left.next = newHead;
            newHead = left;
            left = next;
        }
        //处理特殊情况
        right.next = newHead;
        newHead = right;
        return newHead;
    }


}
