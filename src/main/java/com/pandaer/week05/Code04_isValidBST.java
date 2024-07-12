package com.pandaer.week05;

// https://leetcode.cn/problems/validate-binary-search-tree/
public class Code04_isValidBST {
    public boolean isValidBST(TreeNode root) {
        return method01(root);
    }

    /**
     * 解法一：递归
     * 思路：左子树又右子树自身是平衡二叉树，且左子树的全部值小于该节点的值，右子树的全部值大于该节点的值
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     */
    public boolean method01(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean isLeftMax = isMax(root.val,root.left);
        boolean isRightMin = isMin(root.val,root.right);
        return isLeftMax && isRightMin && method01(root.left) && method01(root.right);
    }

    private boolean isMin(int val, TreeNode right) {
        if (right == null) {
            return true;
        }
        return right.val > val && isMin(val,right.left) && isMin(val,right.right);
    }

    /**
     * 判断给定的值是不是整棵树的最大值
     * @param val
     * @param left
     * @return
     */
    private boolean isMax(int val, TreeNode left) {
        if (left == null) {
            return true;
        }
        return left.val < val && isMax(val,left.left) && isMax(val,left.right);
    }


    /**
     * 解法二：递归
     * 思路：根据二叉搜索树的特点，一个节点的左子树的最大值一定不会超过该节点的值，一个节点的右子树的最小值一定不会小于该节点的值，换句话说就是存在一个上下限
     * 比如左子树中全部节点的值的范围一定在（-inf,该节点的值）右子树的值范围一定落在(该节点的值,+inf)上，
     * 因此我们只需要判断子树中节点的值是否在这个范围呢？如果不在那就一定不是二叉搜索树，如果在，那么需要进一步的判断其左右子树是否也满足。
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public boolean method02(TreeNode root,Integer lower,Integer upper) {
        if(root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        return method02(root.left,lower,root.val) && method02(root.right,root.val,upper);
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
