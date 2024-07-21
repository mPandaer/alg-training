package com.pandaer.codecrush.basic.lesson06;

import java.util.HashMap;
import java.util.Map;

public class Code01_Fibonacci {



    public int fibonacci(int n) {
        return method01(n);
    }

    /**
     * 递归解法
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private Map<Integer,Integer> cache = new HashMap<>();
    public int method01(int n) {
        //终止条件
        if (n == 1 || n == 2) return 1;
        Integer res = cache.get(n);
        if (res != null) {
            return res;
        }

        int left = method01(n - 1) % 1000000007;
        int right = method01(n - 2) % 1000000007;
        cache.put(n,left + right);
        return left + right;

    }


}
