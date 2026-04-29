package codetop.page04.a9;

import java.util.*;

/**
 * @author mlei@xjtu
 * @description 给定一个未排序的整数数组 nums ，
 * 找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * @create 2026/4/29 10:02
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;
        for (int num : nums) {
            if (map.containsKey(num - 1)) {
                maxLength = Math.max(maxLength, map.get(num - 1) + 1);
            }
            map.put(num, 1 + map.getOrDefault(num - 1, 0));
        }
        return maxLength == Integer.MIN_VALUE ? 1 : maxLength;
    }
}
