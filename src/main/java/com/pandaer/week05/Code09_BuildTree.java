package com.pandaer.week05;


import java.util.Arrays;

//https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class Code09_BuildTree {


    /**
     * 根据前序遍历和中序遍历构建树
     * 思路：利用递归的思路实现，我们可以假设buildTree已经实现，于是我们的任务就变成了，确定跟节点，构建左子树，构建右子树
     * 而buildTree可以根据前序和中序遍历构建一棵树，所以我们的问题进一步得到转换，确定左子树的前中序，确定右子树的前中序。
     * 因为前序遍历的第一个节点一定是跟节点，然后我们根据根节点在中序中，那么在左边的就是左子树的中序，在右边的就是右子树的中序
     * 然后无论是中序还是前序，节点的个数是关键，于是根据中序的长度，在前序中确定左子树的前序。根据这个思路就可以构建出一个二叉树了。
     * 时间复杂度：O(n^2)
     * 空间复杂度：每次都会复制数组 O(2n) O(n)
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       if (preorder.length == 0 || inorder.length == 0) {
           return null;
       }
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int iIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (rootVal == inorder[i]) {
                iIndex = i;
                break;
            }
        }

        //构造左子树
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, iIndex);
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + leftInorder.length);
        root.left = buildTree(leftPreorder,leftInorder);

        //构造右子树
        int[] rightInorder = Arrays.copyOfRange(inorder, iIndex + 1, inorder.length);
        int[] rightPreorder = Arrays.copyOfRange(preorder, leftPreorder.length + 1, preorder.length);
        root.right = buildTree(rightPreorder,rightInorder);
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
