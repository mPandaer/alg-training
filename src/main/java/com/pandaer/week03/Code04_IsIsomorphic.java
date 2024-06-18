package com.pandaer.week03;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/isomorphic-strings/?envType=study-plan-v2&envId=top-interview-150">同构字符串</a>
 */
public class Code04_IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        return method01(s, t);
    }


    /**
     * 解法一：HashMap + 词频统计 + 排序
     * 思路：先将每个字符串进行词频统计，然后将词频统计的value部分进行排序，判断序列是否一致
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(k+m)
     * 思路存在问题，错误
     */
    public boolean method01(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        //词频统计
        for (char ch : s.toCharArray()) {
            Integer curCount = sMap.getOrDefault(ch, 0);
            sMap.put(ch, ++curCount);
        }

        for (char ch : t.toCharArray()) {
            Integer curCount = tMap.getOrDefault(ch, 0);
            tMap.put(ch, ++curCount);
        }

        Collection<Integer> sValues = sMap.values();
        Collection<Integer> tValues = tMap.values();
        List<Integer> sList = sValues.stream().sorted().toList();
        List<Integer> tList = tValues.stream().sorted().toList();
        return sList.equals(tList);
    }

    /**
     * 解法二：模拟过程 + 建立两张索引表
     * 思路：模拟题目描述的过程，通过一个HashMap维护一个映射关系，遍历一个字符串，如果这个字符不存在映射关系就创建，如果存在映射关系就判断是否一致
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public boolean method02(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        for (int i = 0; i < sArr.length; i++) {
            Character sMappingChar = sMap.get(sArr[i]);
            Character tMappingChar = tMap.get(tArr[i]);
            if (sMappingChar == null && tMappingChar == null) {
                sMap.put(sArr[i],tArr[i]);
                tMap.put(tArr[i],sArr[i]);
                continue;
            }

            if (sMappingChar == null || tMappingChar == null) {
                return false;
            }

            if (tMappingChar != sArr[i] || sMappingChar != tArr[i]) {
                return false;
            }

        }
        return true;
    }

}
