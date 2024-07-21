package com.pandaer.geektime.week04;

import com.pandaer.geektime.week04.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal/description/">二叉树的中序遍历</a>
 */
public class Code01_InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        return method01(root);
    }


    /**
     * 解法一：递归的方式求解
     * 思路：关于树的遍历问题，是一个可以将大问题拆分成同等规模的小问题，
     * 具体思路是这样的，对于中序遍历，可以先遍历左子树，然后根节点，然后右子树，然后按照这个步骤应用到左子树以及右子树
     * 时间复杂度：O(n)每个节点都访问了一次
     * 空间复杂度：O(n)每访问一个节点，都会存在一个调用栈
     */
    public List<Integer> method01(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        doHandle01(root,list);
        return list;
    }

    /**
     * 递归的方式 中序遍历 help函数
     */
    private void doHandle01(TreeNode root, List<Integer> list) {
        if (root == null) return;
        doHandle01(root.left,list);
        list.add(root.val);
        doHandle01(root.right,list);
    }


}
