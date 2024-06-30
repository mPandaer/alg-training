package com.pandaer.week04;

import com.pandaer.week04.node.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/n-ary-tree-postorder-traversal/">N 叉树的后序遍历</a>
 */

public class Code03_Postorder {

    public List<Integer> postorder(Node root) {
        return method01(root);
    }


    /**
     * 解法一：递归
     * 思路：
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public List<Integer> method01(Node root) {
        List<Integer> list = new ArrayList<>();
        help01(root,list);
        return list;
    }

    /**
     * 递归 辅助函数
     * 定义：将遍历的节点加入到list中
     */
    private void help01(Node root, List<Integer> list) {
        if (root == null) return;
        for (Node childNode : root.children) {
            help01(childNode,list);
        }
        list.add(root.val);
    }


}
