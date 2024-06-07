package com.pandaer.week01;


import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/linked-list-cycle/">环形链表</a>
 */
public class Code08_HasCycle {


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

    public boolean hasCycle(ListNode head) {
        return method01(head);
    }


    /**
     * 方法一：存值 + 判断
     * 思路：我们可以遍历整个链表，在遍历的过程中，将节点加入到一个HashSet，在加入之前，如果已经存在，那么就可以判断该链表存在一个环
     * 如果能够结束循环，那么就说明该链表没有环
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param head
     * @return
     */
    public boolean method01(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 方法二：模拟现实世界的跑步（快慢指针）
     * 思路：我们可以把链表想象成一个跑道，如果不是环形跑道，那么跑的快的一定比跑得慢的先到终点，永远不会相遇
     * 如果是一个环形跑道，同一地点出发，跑得快的一定能够遇到跑的慢的。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    public boolean method02(ListNode head) {
        if (head == null) {
            return false;
        }
        //同一起点出发
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }



}
