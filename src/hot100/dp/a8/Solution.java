package hot100.dp.a8;

/**
 * @author mlei@xjtu
 * @description 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 测试用例的答案是一个 32-位 整数。
 * 请注意，一个只包含一个元素的数组的乘积是这个元素的值。
 * @create 2026/3/27 17:22
 */
public class Solution {
    public int maxProduct(int[] nums) {
        long max=nums[0],min=nums[0];
        long result=nums[0];
        for (int i = 1; i < nums.length; i++) {
            long tempMax=max,tempMin=min;
            max=Math.max(nums[i],Math.max(tempMax*nums[i],tempMin*nums[i]));
            min=Math.min(nums[i],Math.min(tempMax*nums[i],tempMin*nums[i]));
            result=Math.max(max,result);
            if(min<-1<<31 ) min=nums[i];
        }
        return (int)result;
    }
}
