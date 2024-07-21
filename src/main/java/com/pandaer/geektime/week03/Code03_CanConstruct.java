package com.pandaer.geektime.week03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/ransom-note/?envType=study-plan-v2&envId=top-interview-150">赎金信</a>
 */
public class Code03_CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        return method01(ransomNote,magazine);
    }


    /**
     * 解法一：排序 判断是否是子串
     * 思路：将字符串按照字母顺序排序，然后判断排序后的字符串是不是另外一个的子串。
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(n+m)
     * 这个解法 考虑不全面，可以不是子串 思路错误
     */
    public boolean method01(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        char[] ransomNoteCharArray = ransomNote.toCharArray();
        Arrays.sort(ransomNoteCharArray);
        char[] magazineCharArray = magazine.toCharArray();
        Arrays.sort(magazineCharArray);

        //判断是否是子串
        int index = -1;
        for (int i = 0; i< magazineCharArray.length;i++) {
            if (magazineCharArray[i] == ransomNoteCharArray[0]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }

        for (int i = index,j = 0; j < ransomNoteCharArray.length;j++,i++) {
            if (ransomNoteCharArray[j] != magazineCharArray[i]) {
                return false;
            }
        }

        return true;
    }


    /**
     * 解法二：HashMap + 词频统计
     * 思路：将每个字符串，都进行一次词频统计，然后遍历ransomNote的词频，判断magazine中的词频是否够
     * 时间复杂度：O(n)
     * 空间复杂度：(k+m) 其中k是ransomNote的单词种类 m是magazine的种类
     */
    public boolean method02(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        Map<Character,Integer> ransomNoteMap = new HashMap<>();
        Map<Character,Integer> magazineMap = new HashMap<>();

        //词频统计
        for (char ch: ransomNote.toCharArray()) {
            Integer curCount = ransomNoteMap.getOrDefault(ch, 0);
            ransomNoteMap.put(ch,++curCount);
        }

        for (char ch: magazine.toCharArray()) {
            Integer curCount = magazineMap.getOrDefault(ch, 0);
            magazineMap.put(ch,++curCount);
        }

        //判断
        for (Character ch : ransomNoteMap.keySet()) {
            Integer needCount = ransomNoteMap.get(ch);
            Integer totalCount = magazineMap.getOrDefault(ch, 0);
            if (totalCount < needCount) {
                return false;
            }
        }
        return true;
    }

    /**
     * 解法三：HashTable + 数组 + 词频统计
     * 思路：针对解法二的优化，根据题目的意思字符的种类只有26种，即全是小写字母，所以我们可以优化HashMap的空间，用数组 + HashTable的思想
     * 来替代 HashMap,即将重量级的数据结构换成轻量级的数据结构
     * 大致逻辑是这样的，先根据magazine进行词频统计加，再根据ransomNote进行词频统计减，在减之前判断。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public boolean method03(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] countArr = new int[26];

        for (char ch : magazine.toCharArray()) {
            countArr[ch - 'a']++;
        }

        for (char ch : ransomNote.toCharArray()) {
            int count = countArr[ch - 'a'];
            if (count <= 0) {
                return false;
            }
            countArr[ch - 'a']--;
        }

        return true;
    }

}
