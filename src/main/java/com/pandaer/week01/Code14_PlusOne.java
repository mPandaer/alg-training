package com.pandaer.week01;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/plus-one/">加一</a>
 */
public class Code14_PlusOne {

    public int[] plusOne(int[] digits) {
        return method01(digits);
    }


    /**
     * 解法一：将数组转换为数字，然后进行加一操作，最后再转换为数组
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * 解答错误：因为int的范围限制，导致某些测试数据溢出。
     * @param digits
     * @return
     */
    public int[] method01(int[] digits) {
        int num = 0;
        for (int i = 0; i< digits.length;i++) {
            num = num * 10 + digits[i];
        }
        num++;
        LinkedList<Integer> list = new LinkedList<>();
        while (num > 0) {
            list.addFirst(num % 10);
            num /= 10;
        }
        return list.stream().mapToInt(item -> item).toArray();
    }

    /**
     * 方法二：模拟加法
     * 思路：模拟加法操作来计算
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param digits
     * @return
     */
    public int[] method02(int[] digits) {
        int carry = 0;
        for (int last = digits.length - 1;last >= 0; last--) {
            int value = last == digits.length-1 ? 1 : 0;
            int res = digits[last] + value + carry;
            digits[last] = res % 10;
            carry = res / 10;
        }
        if (carry == 0) {
            return digits;
        }
        int[] newArr = new int[digits.length + 1];
        newArr[0] = carry;
        System.arraycopy(digits,0,newArr,1,digits.length);
        return newArr;
    }




}
