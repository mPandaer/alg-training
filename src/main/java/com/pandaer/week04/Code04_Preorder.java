package com.pandaer.week04;

import com.pandaer.week04.node.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/n-ary-tree-postorder-traversal/">N 叉树的后序遍历</a>
 */

public class Code04_Preorder {

    public List<Integer> preorder(Node root) {
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
     * 辅助函数
     * @param root
     * @param list
     */
    private void help01(Node root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        for (Node child : root.children) {
            help01(child,list);
        }
    }

}
