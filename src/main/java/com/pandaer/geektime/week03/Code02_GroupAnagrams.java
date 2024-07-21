package com.pandaer.geektime.week03;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/group-anagrams/">字母异位词分组</a>
 */
public class Code02_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        return method03(strs);
    }


    /**
     * 解法一：暴力解法
     * 思路：遍历数组，判断两两字符串是否为异位词
     * 时间复杂度：O(n^3)
     * 空间复杂度：O(1)
     */
    public List<List<String>> method01(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i< strs.length;i++) {
            if (strs[i].equals("-1")) continue;
            List<String> temp = new ArrayList<>();
            temp.add(strs[i]);
            for (int j = i + 1; j < strs.length;j++) {
                if (strs[j].equals("-1")) continue;
                if (isAnagrams(strs[i],strs[j])) {
                    temp.add(strs[j]);
                    strs[j] = "-1";
                }
            }
            res.add(temp);
            strs[i] = "-1";
        }
        return res;
    }


    /**
     * 解法二：Hash解法
     * 思路：由于互为异位词的字符串，在进行排序后，一定是一样的，所以我们可以用这个作为key,然后只要排序后的字符是这个key就加入
     * 时间复杂度：O(n*k*logk) n为字符数组的长度，k为字符串数组中最长的字符串长度
     * 空间复杂度：O(nk)
     */
    public List<List<String>> method02(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i< strs.length;i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sorted = String.valueOf(charArray);
            List<String> list = map.getOrDefault(sorted, new ArrayList<>());
            list.add(strs[i]);
            map.put(sorted,list);
        }

        return map.values().stream().toList();
    }


    /**
     * 解法三：Hash解法 + 数组
     * 思路：优化解法二，因为解法二在确定异位词的key上使用的是排序，复杂度有点高，因为字符种类被限制在了26个字母上
     * 所以我们可以这样来确定key 字母+对应出现的次数，如果是异位词的话，那么必然是这样的顺序。
     * 时间复杂度：O(n*max(k,26))
     * 空间复杂度：(nk)
     */
    public List<List<String>> method03(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i< strs.length;i++) {
            int[] arr = new int[26];
            for (int j = 0; j < strs[i].length();j++) {
                arr[strs[i].charAt(j) - 'a']++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j<arr.length; j++) {
                if (arr[j] != 0) {
                    stringBuilder.append('a' + j).append(arr[j]);
                }
            }
            String key = stringBuilder.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(strs[i]);
            map.put(key,list);
        }

        return map.values().stream().toList();
    }

    public static void main(String[] args) {
        String[] strings = {"eat","tea","ate"};
        new Code02_GroupAnagrams().groupAnagrams(strings);
    }


    private boolean isAnagrams(String s, String t) {
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
}
