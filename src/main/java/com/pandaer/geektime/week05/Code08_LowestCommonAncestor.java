package com.pandaer.geektime.week05;


import java.util.LinkedList;
import java.util.Queue;

//
public class Code08_LowestCommonAncestor {


    /**
     * 思路：假设存在一个函数能够判断某个节点是否在以某个节点为根节点的树上是否存在
     * @param root
     * @param p
     * @param q
     * @return
     */
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (p == root || q == root) {
//            return root;
//        }
//
//        //判断是否在不同的子树上
//        boolean isPExist = isExist(root.left,p);
//        boolean isQExist = isExist(root.left,q);
//        if (isPExist && !isQExist || isQExist && !isPExist) {
//            return root;
//        }
//
//        if (isPExist) {
//            return lowestCommonAncestor(root.left,p,q);
//        }
//
//        return lowestCommonAncestor(root.right,p,q);
//
//    }


    /**
     * 别人的解法
     * @param root
     * @param p
     * @param q
     * @return
     */
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null || p == root || q == root) {
//            return root;
//        }
//        TreeNode left = lowestCommonAncestor(root.left,p,q);
//        TreeNode right = lowestCommonAncestor(root.right,p,q);
//        if (left == null) {
//            return right;
//        }
//        if (right == null) {
//            return left;
//        }
//
//        return root;
//    }


    /**
     * 别人的解法 理解不了 背下来
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return root;
    }

    /**
     * 判断该节点是否存在于这个树上
     * @param root
     * @param p
     * @return
     */
    private boolean isExist(TreeNode root, TreeNode p) {
        if (root == p) return true;
        if (root == null) {
            return false;
        }
        return isExist(root.left,p) || isExist(root.right,p);
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
