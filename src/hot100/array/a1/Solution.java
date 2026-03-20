package hot100.array.a1;

/**
 * @author mlei@xjtu
 * @description 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组是数组中的一个连续部分。
 * @create 2026/3/20 16:50
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        //dp数组维护以索引下标为终点的子数组的最大值
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
