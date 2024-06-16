package com.pandaer.week03;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/valid-anagram/">有效的字母异位词</a>
 */
public class Code01_IsAnagram {
    public boolean isAnagram(String s, String t) {
        return method01(s,t);
    }


    /**
     * 解法一：词频统计 + 数组HASH
     * 思路：由于题目明确指出，字符串中只包含小写字母，那么就可以创建一个26长度的数组，每个数组的位置，对应一个字母出现的次数
     * 先遍历一个字符串，进行词频加，再遍历第二个字符串进行词频减，最后判断数组中是否存在不为零的数。
     * 不存在就是true,存在就是false
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public boolean method01(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i< s.length();i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i<t.length();i++) {
            count[t.charAt(i) - 'a']--;
        }

        for (int j : count) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 解法二：词频统计 + HashMap
     * 思路：思路和解法一相似，遍历一个字符串，进行词频加操作，遍历另外一个字符串，如果存在就进行词频减操作，如果不存在就可以直接返回了
     * 最后，判断Map的values中是否存在不为零的数。
     * 时间复杂度：
     * 空间复杂度：
     */
    public boolean method02(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i< s.length();i++) {
            Integer count = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i),++count);
        }

        for (int i = 0; i<t.length();i++) {
            if (!map.containsKey(t.charAt(i))) {
                return false;
            }
            Integer count = map.get(t.charAt(i));
            map.put(t.charAt(i),--count);
        }

        long count = map.values().stream().filter(item -> item != 0).count();
        return count == 0;
    }



    public static void main(String[] args) {
        System.out.println(new Code01_IsAnagram().isAnagram("rat", "car"));
    }
}
