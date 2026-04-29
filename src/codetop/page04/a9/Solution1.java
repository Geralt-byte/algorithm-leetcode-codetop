package codetop.page04.a9;

import java.util.*;

/**
 * @author mlei@xjtu
 * @description 给定一个未排序的整数数组 nums ，
 * 找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * @create 2026/4/29 10:02
 */
public class Solution1 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLength = Integer.MIN_VALUE;
        for (Integer i : set) {
            if (!set.contains(i - 1)) {
                int count = 1;
                while (set.contains(i + 1)) {
                    count++;
                    i++;
                }
                maxLength = Math.max(maxLength, count);
            }
        }
        return maxLength;
    }
}
