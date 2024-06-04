package com.pandaer.week01;


/**
 * <a href="https://leetcode.cn/problems/climbing-stairs/description/">爬楼梯</a>
 */
public class Code04_ClimbStairs {

    public int climbStairs(int n) {
        return method01(n);
    }

    /**
     * 递归算法的时间复杂度估计？？？
     * 方法一
     * 思路：这道题，经过分析可以利用递归来解，举个例子，求到达n阶台阶的的方式，其实就是求 到达 n-1阶和n-2阶的方法之和。然后可以以此类推
     * 大问题变成同等类型的小问题，
     * 时间复杂度：？？？
     * 空间复杂度：log(N)
     * 提交代码失败，超出时间限制
     */
    public int method01(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return method01(n-1) + method01(n-2);
    }

    /**
     * 方法二：动态规划：感觉就是递归的迭代改写
     * 思路：思路还是一样，只是将递归写法改为非递归写法，类比将斐波拉契数列从递归写法改为非递归写法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int method02(int n) {
        if ( n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int q = 1,p = 2,r = 0;
        for (int i = 2; i < n; i++) {
            r = q + p;
            //准备计算下一次
            q = p;
            p = r;
        }
        return r;
    }




}
