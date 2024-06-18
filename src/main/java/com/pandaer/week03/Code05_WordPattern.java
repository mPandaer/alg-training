package com.pandaer.week03;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/word-pattern/?envType=study-plan-v2&envId=top-interview-150">单词规律</a>
 */
public class Code05_WordPattern {
    public boolean wordPattern(String pattern, String s) {
        return method01(pattern,s);
    }


    /**
     * 解法一：和异构字符串的解法类似，建立双向索引表
     * 思路：将字符串s按照空格分割为单词，判断单词的数量是否和pattern的数量一致，然后遍历pattern,建立双向映射表，判断是否一一对应
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public boolean method01(String pattern, String s) {
        String[] wordList = s.split(" ");
        char[] patternList = pattern.toCharArray();
        if (patternList.length != wordList.length) {
            return false;
        }
        Map<Character,String> patternMap = new HashMap<>();
        Map<String,Character> wordMap = new HashMap<>();

        for (int i = 0; i< patternList.length;i++) {
            String patternMappingStr = patternMap.get(patternList[i]);
            Character wordMappingChar = wordMap.get(wordList[i]);
            if (patternMappingStr == null && wordMappingChar == null) {
                patternMap.put(patternList[i],wordList[i]);
                wordMap.put(wordList[i],patternList[i]);
                continue;
            }

            if (patternMappingStr == null || wordMappingChar == null) {
                return false;
            }

            if (!patternMappingStr.equals(wordList[i]) || wordMappingChar != patternList[i]) {
                return false;
            }

        }

        return true;

    }

}
