package com.pandaer.geektime.week04;

import com.pandaer.geektime.week04.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-preorder-traversal/">二叉树的前序遍历</a>
 */
public class Code02_PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        return method01(root);
    }


    /**
     * 解法一：递归
     * 思路：和中序遍历一致，由于遍历的问题可以由一个大问题不断的拆分成一个一个的小规模问题，而这些小规模问题最后可以拆分为最小子问题，
     * 而这个最小子问题的答案，轻而易举就得出。
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public List<Integer> method01(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        help01(root,list);
        return list;
    }

    /**
     * 前序遍历-递归
     */
    private void help01(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        help01(root.left,list);
        help01(root.right,list);
    }


}
