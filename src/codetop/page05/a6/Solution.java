package codetop.page05.a6;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mlei@xjtu
 * @description 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 * @create 2026/5/6 10:52
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 1) return nums[0] == k ? 1 : 0;
        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0, result = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (map.containsKey(preSum - k)) {
                result += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return result;
    }
}
