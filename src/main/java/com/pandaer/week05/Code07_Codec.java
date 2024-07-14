package com.pandaer.week05;


import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
public class Code07_Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return doSerialize(root);
    }

    /**
     * 思路：基于层序遍历来序列化字符串
     * 时间复杂度：O(n)
     * 空间复杂度：叶子节点的个数
     */
    private String doSerialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("#,");
            }else {
                sb.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return sb.substring(0,sb.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return doDeserialize(data);
    }

    /**
     * 利用层序遍历反序列化
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private TreeNode doDeserialize(String data) {
        if ("#".equals(data)) return null;
        String[] array = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"#".equals(array[index])) {
                node.left = new TreeNode(Integer.parseInt(array[index]));
                queue.add(node.left);
            }
            index++;
            if (!"#".equals(array[index])) {
                node.right = new TreeNode(Integer.parseInt(array[index]));
                queue.add(node.right);
            }
            index++;
        }

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


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        root.right.right = new TreeNode(5);

        Code07_Codec code07Codec = new Code07_Codec();
        String serialize = code07Codec.serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = code07Codec.deserialize(serialize);
        System.out.println(deserialize);

    }


}
