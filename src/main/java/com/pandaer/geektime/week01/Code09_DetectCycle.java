package com.pandaer.geektime.week01;


import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/linked-list-cycle-ii">环形链表 II</a>
 */
public class Code09_DetectCycle {


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


    public ListNode detectCycle(ListNode head) {
        return method01(head);
    }


    /**
     * 方法一：hashSet + 遍历
     * 思路：和判断是否有环一样的思路，在遍历的过程中，先判断集合中是否存在这个节点，
     * 如果存在就说明有环，那么就直接返回这个节点，如果能够退出节点就返回null
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public ListNode method01(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    /**
     * 方法二：同样可以模拟跑步问题（快慢指针）
     * 思路：这是一道数学题，我们假设，从起点到环起始点距离为a,环起始点到相遇点为b,相遇点回到起始点为c
     * 因为快指针的速度是慢指针的两倍，由于运动时间相等，所以快指针行驶的距离也是慢指针的两倍
     * a + b + n(b + c) = 2(a + b)
     * 化简：a = (n-1)b + nc
     * 当n=1时，a = c
     * 所以只要相遇之后，一个从头开始，一个从相遇点开始，如果再次相遇，那么就是环的起始点
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public ListNode method02(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean flag = false;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast =fast.next.next;
            if (slow == fast) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }



}
