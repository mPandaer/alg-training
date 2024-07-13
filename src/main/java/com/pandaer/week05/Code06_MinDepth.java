package com.pandaer.week05;

import java.util.ArrayDeque;
import java.util.Queue;

// https://leetcode.cn/problems/validate-binary-search-tree/
public class Code06_MinDepth {


    public int minDepth(TreeNode root) {
        return method01(root);
    }


    /**
     * 解法一：递归
     * 思路：先求出该节点左子树的最小深度，以及右子树的最小深度，然后再取其中的最小值并+1就是最终的结果
     * 时间复杂度：O(n) n为树的节点个数
     * 空间复杂度：O(h) h为树的最大深度
     */
    public int method01(TreeNode root) {
        //递归终止条件
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        //本层逻辑
        int left = -1;
        if (root.left != null) {
            left = method01(root.left);
        }
        int right = -1;
        if (root.right != null) {
            right = method01(root.right);
        }

        //整合子问题
        if (left == -1) {
            return right + 1;
        }

        if (right == -1) {
            return left + 1;
        }

        return Math.min(left,right) + 1;

    }


    /**
     * 解法二 广度优先遍历
     * 思路：一层一层的遍历，只要遍历的节点是叶子节点那么这个一定是最小的深度了
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int method02(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                if (node.left == null && node.right == null) {
                    return level;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
        }

        return level;

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
