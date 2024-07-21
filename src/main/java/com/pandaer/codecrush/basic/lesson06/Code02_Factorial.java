package com.pandaer.codecrush.basic.lesson06;

import java.util.HashMap;
import java.util.Map;

public class Code02_Factorial {

    public int factorial(int n) {
        return method01(n);
    }


    /**
     * 递归解法
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param n
     * @return
     */
    public int method01(int n) {
        // 递归终止条件
        if (n == 0 || n == 1) return 1;
        return (n * method01(n-1)) % 7777777;
    }
}
