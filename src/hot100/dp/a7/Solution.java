package hot100.dp.a7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author mlei@xjtu
 * @description 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * @create 2026/3/27 17:22
 */
public class Solution {
    //dp[i] 表示以i索引结尾的子串的最大长度，子串必须包括i索引
    //状态转移方程    dp[i]=max(dp[i],dp[j]+1),0<=j<i&&nums[j]<nums[i]
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=1;
        int result=1;
        for (int i = 1; i < nums.length; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
            result= Math.max(result,dp[i]);
        }
        return result;
    }
}
