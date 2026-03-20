package hot100.array.a5;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mlei@xjtu
 * @description 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * @create 2026/3/20 22:52
 */
public class Solution2 {
    public int firstMissingPositive(int[] nums) {
        //官方题解1
        if (nums.length == 1) return nums[0] == 1 ? 2 : 1;
        int n=nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i]<=0||nums[i]>n) nums[i]=n+1;
        }
        for (int i = 0; i < n; i++) {
            if(Math.abs(nums[i])!=n+1){
                if(nums[Math.abs(nums[i])-1]>0) nums[Math.abs(nums[i])-1]*=-1;
            }
        }
        for (int i = 0; i < n; i++) {
            if(nums[i]>0) return i+1;
        }
        return n+1;
    }
}
