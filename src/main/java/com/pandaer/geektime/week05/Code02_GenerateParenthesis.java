package com.pandaer.geektime.week05;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/generate-parentheses/
public class Code02_GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        method01(n,n,"",list);
        return list;
    }

    /**
     * 解法一
     * 思路: 第一版的思路是先生成全部可能的括号,然后根据最终生成的括号判断是否匹配得到答案,但是经过观察和思考,
     * 发现其实没有必要等到最后再来判断是否匹配,完全可以在生成括号的过程中进行判断,分为两种情况,如果是左括号就一直添加,
     * 如果是右括号就需要再生成的字符串中,左括号的个数要大于右括号
     * 递归函数定义: 根据n的值生成多少长度的括号
     * 递归树的最大高度：2n
     * 时间复杂度:
     * 空间复杂度:
     */
    public void method01(int left,int right,String str,List<String> res) {
        //递归终止条件
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }

        //本层逻辑
        if (left > 0) {
            method01(left-1,right,str + "(",res);
        }

        if (left < right) {
            method01(left,right -1,str + ")",res);
        }

    }


    @Test
    public void testSample() {
        List<String> strings = generateParenthesis(3);
        strings.forEach(System.out::println);
    }

}
