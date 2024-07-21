package com.pandaer.geektime.week03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/happy-number/?envType=study-plan-v2&envId=top-interview-150">快乐数</a>
 */
public class Code06_IsHappy {
    public boolean isHappy(int n) {
        return method01(n);
    }


    /**
     * 解法一：HashSet 校验循环
     * 思路：这道题目属于规律题，你需要从数据中找寻规律，根据题目中的解释
     * 我们大胆猜测会出现三种情况
     * 1. 最后到1
     * 2. 陷入循环中
     * 3. 无限变大
     * 这是我们的猜测，我们需要验证，由于第一种和第二种都是题目描述，所以毋庸置疑，但是第三种，需要我们验证，其实你仔细验证就会发现，绝对不可能，
     * 因为针对3位数的最大数999 进行第一计算后就变小了，更不要说其他的了，反正必然无法突破3位数的上限去到4位数，对于4位数也是一样，永远无法突破到4位数，你可以试试
     * 所以我们只需要解决上面两种情况 1. 最后到1， 2.陷入循环中
     * 时间复杂度：O(logn) todo 不理解
     * 空间复杂度：O(logn)
     */
    public boolean method01(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            n = getNext(n);
        }
        return true;
    }


    /**
     * 解法二：快慢指针
     * 思路：针对思路一，我们可以进行优化，因为循环的检测除了Set集合外，还有一个方法，快慢指针，如果陷入循环快慢指针就会相遇，如果没有陷入循环，快指针就会到达终点，也就是1
     * 时间复杂度：
     * 空间复杂度：
     */
    public boolean method02(int n) {
        int low = getNext(n);
        int fast = getNext(getNext(n));
        while (fast != 1) {
            if (low == fast) {
                return false;
            }
            low = getNext(low);
            fast = getNext(getNext(fast));
        }
        return true;
    }







    private int getNext(int n) {
        int res = 0;
        while (n != 0) {
            res += (n%10) * (n%10);
            n /= 10;
        }
        return res;
    }


}
