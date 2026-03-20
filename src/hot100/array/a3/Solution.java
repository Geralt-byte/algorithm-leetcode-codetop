package hot100.array.a3;

import java.util.Arrays;

/**
 * @author mlei@xjtu
 * @description 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * @create 2026/3/20 22:52
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        if(k==0||k%nums.length==0||nums.length==1) return;
        k%=nums.length;
        reserveArray(nums,0, nums.length-1);
        reserveArray(nums,0, k-1);
        reserveArray(nums,k, nums.length-1);
    }

    public void reserveArray(int[] nums,int start,int end){
        while (start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
