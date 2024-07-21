package com.pandaer.geektime.week05;

// https://leetcode.cn/problems/invert-binary-tree/
public class Code03_InvertTree {



    public TreeNode invertTree(TreeNode root) {
        return method01(root);
    }

    /**
     * 解法一
     * 思路：发现重复性，反转二叉树，针对根节点，就是先翻转左右子树，然后再调换左右子节点，然后针对左右子树也是这个过程，
     * 于是就可以利用递归来解决
     * 时间复杂度：
     * 空间复杂度：
     */
    public TreeNode method01(TreeNode root) {
        //递归终止条件
        if (root == null) {
            return null;
        }
        //本层处理逻辑
        TreeNode left = method01(root.left);
        TreeNode right = method01(root.right);
        //组合子问题
        root.right = left;
        root.left = right;
        return root;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
