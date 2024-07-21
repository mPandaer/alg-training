package com.pandaer.geektime.week05;


// https://leetcode.cn/problems/climbing-stairs/

import java.util.HashMap;
import java.util.Map;

public class Code01_ClimbStairs {
    public int climbStairs(int n) {
        return method01(n);
    }


    /**
     * 傻递归解法
     * 思路：我们在分析问题的时候 存在两种思路
     * 第一种就是不依赖任何东西，从零开始一步一步计算出结果
     * 另外一种思路，站在巨人的肩膀上，通过整合巨人的成果得到结果
     * 第一种思路符合我们的直觉，所以是我们经常依赖第一种思路，
     * 但是有时候第二种思路在某些情况下可能比第一种思路更加的简单
     * 就比如这道题，通过枚举一些小情况，你会发现答案符合斐波拉契数列，
     * 于是这道题就可以转换为斐波拉契数列的解法
     * 时间复杂度：O(2^n) 每次递归都会分裂为两个，然后继续这样分裂直到n=1,
     * 最后会是一颗完全二叉树，树的每一个节点的计算都是O(1) 有2^n-1这么多个节点，所以时间复杂度O(2^n)
     * 空间复杂度：O(n) 空间复杂度主要是调用栈的占用，而最大的空间就是调用栈的最大深度，而调用栈的最大深度就是n,比如从10一直递到1才结束
     * 所以深度就是10
     * 测试结果：时间超时
     */
    public int method01(int n) {
        if (n <= 2) {
            return n;
        }
        return method01(n - 1) + method01(n - 2);
    }


    /**
     * 递归解法 + 缓存
     * 思路：基于解法一，解法一时间超时是因为大量计算之前重复算过的结果了，我们需要加一个缓存来解决问题
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public Map<Integer,Integer> cache = new HashMap<>();
    public int method02(int n) {
        //递归终止条件
        if (n <= 2) {
            return n;
        }

        //本层递前的逻辑处理
        Integer res = cache.get(n);
        if (res == null) {
            res = method02(n-1) + method02(n-2);
            //本层归后的逻辑处理
            cache.put(n,res);
        }
        return res;
    }

    /**
     * 迭代解法
     * 思路：在解法一分析的时候发现，这就是一个斐波拉契的问题，而斐波拉契的问题就是一个递推公式
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int method03(int n) {
        if (n <= 2) {
            return n;
        }
        int p1 = 1;
        int p2 = 2;
        int p3 = 0;
        for (int i = 2; i <n; i++) {
            p3 = p1 + p2;
            p1 = p2;
            p2 = p3;
        }

        return p3;
    }

}
