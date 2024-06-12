package com.pandaer.week02;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a href='https://leetcode.cn/problems/valid-parentheses/'>有效的括号</a>
 */
public class Code01_IsValid {
    public boolean isValid(String s) {
        return method01(s);
    }

    /**
     * 解法一：利用栈解决
     * 思路：只要是左括号就入栈，如果是右括号，就判断当前栈顶的元素是否和当前右括号匹配，如果不匹配就可以返回不是有效括号了，如果匹配了就继续看，知道最后都匹配。
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param s
     * @return
     */
    public boolean method01(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (isLeft(ch)) {
                stack.push(ch);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            Character topCh = stack.pop();
            if (!isPair(topCh,ch)) {
                return false;
            }

        }
        return stack.isEmpty();
    }

    private boolean isPair(Character topCh, char ch) {
        return Math.abs(topCh - ch) <= 2;
    }

    private boolean isLeft(char ch) {
        return ch == '[' || ch == '(' || ch == '{';
    }
}
