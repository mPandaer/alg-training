package com.pandaer.geektime.week01;



import java.util.*;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.cn/problems/rotate-array/">轮转数组</a>
 */
public class Code12_Rotate {

    public void rotate(int[] nums, int k) {
        method01(nums,k);
    }

    /**
     * 解法一：一次轮转一个，轮转k次
     * 思路：为了不使用额外的空间，我们可以一次操作一个元素，即将最后一个元素提取出来，将其他的元素都往后移动一格，最后再讲最后一个元素，放到移动后数组的第一格，这个过程重复K次就完成了
     * 时间复杂度：O(n*k)
     * 空间复杂度：O(1)
     * 超出时间限制
     * @param nums
     * @param k
     */
    public void method01(int[] nums, int k) {
        k = k % nums.length;
        for (int i = 0; i< k; i++) {
            int last = nums[nums.length - 1];
            for (int j = nums.length-2; j >= 0; j--) {
                nums[j+1] = nums[j];
            }
            nums[0] = last;
        }
    }

    /**
     * 解法二：
     * 思路：使用k个空间，先存储要放置到前面的数组，然后移动剩余的数组，然后再讲之前拿出来的元素放回。
     * 时间复杂度：O(n + k)
     * 空间复杂度：O(k)
     * @param nums
     * @param k
     */
    public void method02(int[] nums, int k) {
        k = k % nums.length;
        List<Integer> list = new ArrayList<>(k);
        for (int index = nums.length - k; index < nums.length;index++) {
            list.add(nums[index]);
        }

        for (int i = nums.length - k - 1; i >=0; i--) {
            nums[i + k] = nums[i];
        }

        for (int i = 0; i< k; i++) {
            nums[i] = list.get(i);
        }

    }


    /**
     * 解法三：双端队列
     * 思路：使用一个双端队列，先将元素添加进去，然后从尾部移动一个出来，再从头部添加进去就可以了 重复上面这个动作k次，就完成了
     * 时间复杂度：O(n + k)
     * 空间复杂度：O(n)
     * @param nums
     * @param k
     */
    public void method03(int[] nums, int k) {
        Deque<Integer> deque = Arrays.stream(nums).boxed().collect(Collectors.toCollection(LinkedList::new));
        k = k % nums.length;
        for (int i = 0; i< k; i++) {
            Integer last = deque.removeLast();
            deque.addFirst(last);
        }
        int[] arr = deque.stream().mapToInt(item -> item).toArray();
        System.arraycopy(arr, 0, nums, 0, nums.length);
    }




}
