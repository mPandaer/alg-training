package com.pandaer.geektime.week04;

import com.pandaer.geektime.week04.node.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/n-ary-tree-level-order-traversal/">N 叉树的层序遍历</a>
 */

public class Code05_LevelOrder {


    public List<List<Integer>> levelOrder(Node root) {
        return method01(root);
    }


    /**
     * 解法一：队列 + 迭代
     * 思路：
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public List<List<Integer>> method01(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node != null) {
                    list.add(node.val);
                    if (node.children != null) {
                        queue.addAll(node.children);
                    }
                }
            }
            res.add(list);
        }
        return res;
    }



}
