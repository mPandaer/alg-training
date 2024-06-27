package com.pandaer.codecrush.struct.tree;

import com.pandaer.codecrush.struct.tree.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 树的基础操作 遍历
 */
public class Code01_BasicTree {


    /**
     * 前序遍历的递归写法
     * @param root
     */
    public void preOrderWithRec(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preOrderWithRec(root.left);
        preOrderWithRec(root.right);
    }

    /**
     * 将递归写法 改造为迭代写法
     */
    public void preOrderWithIter(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return;
        }
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.println(pop.val);
            if (pop.right != null) stack.push(pop.right);
            if (pop.left != null) stack.push(pop.left);
        }

    }

    /**
     * 中序遍历的递归写法
     * @param root
     */
    public void inOrderWithRec(TreeNode root) {
        if (root == null) return;
        inOrderWithRec(root.left);
        System.out.println(root.val);
        inOrderWithRec(root.right);
    }


    /**
     * 中序遍历迭代写法
     * @param root
     */
    public void inOrderWithIter(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.println(pop.val);
            if (pop.right != null) stack.push(pop.right);
        }

    }



    /**
     * 后序遍历的递归写法
     * @param root
     */
    public void postOrderWithRec(TreeNode root) {
        if (root == null) return;
        postOrderWithRec(root.left);
        postOrderWithRec(root.right);
        System.out.println(root.val);
    }

    public void postOrderWithIter(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new LinkedList<>();

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        Code01_BasicTree code01BasicTree = new Code01_BasicTree();
        code01BasicTree.inOrderWithRec(root);
        System.out.println("=======================");
        code01BasicTree.inOrderWithIter(root);
//        System.out.println("=======================");
//        code01BasicTree.postOrderWithRec(root);
    }

}
