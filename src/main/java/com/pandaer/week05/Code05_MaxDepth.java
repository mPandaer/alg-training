package com.pandaer.week05;

// https://leetcode.cn/problems/validate-binary-search-tree/
public class Code05_MaxDepth {


    /**
     * 最大深度问题
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return method01(root);
    }


    /**
     * 解法一： 递归解决
     * 思路：求一颗树的最大高度，等于左子树和右子树的最大深度的较大值 + 1
     * 时间复杂度：O(n) n为树的节点数
     * 空间复杂度：O(h) h为树的高度
     */
    public int method01(TreeNode root) {
        if (root == null) return 0;
        return Math.max(method01(root.left),method01(root.right)) + 1;
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
