package com.pandaer.codecrush.basic.lesson06;

import java.util.HashMap;
import java.util.Map;

public class Code03_ClimbStairs1 {

    public int climbStairs(int n) {
        return method01(n);
    }


    /**
     * 递归解法
     * @param n
     * @return
     */
    Map<Integer,Integer> map = new HashMap<>();
    public int method01(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        Integer res = map.get(n);
        if (res != null) {
            return res;
        }
        res = method01(n-1) + method01(n-2);
        map.put(n,res);
        return res;
    }
}
