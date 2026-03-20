package hot100.array.a4;

/**
 * @author mlei@xjtu
 * @description 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除了 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * @create 2026/3/20 22:52
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length==2) return new int[]{nums[1],nums[0]};
        int n=nums.length;
        //left数组存储元素右边乘积，right数组存储右边乘积
        int[] left=new int[n];
        int[] right=new int[n];
        left[0]=1;
        right[n-1]=1;
        boolean flag=false;
        int index=0;
        for (int i = 1,j=n-2; i < n; i++,j--) {
            if(nums[i]==0) {
                index=i;
                flag=true;
            }
            if(nums[j]==0) {
                index=j;
                flag=true;
            }
            left[i]=nums[i-1]*left[i-1];
            right[j]=nums[j+1]*right[j+1];
        }
        int[] result=new int[n];
        if (!flag) {
            for (int i = 0; i < n; i++) {
                result[i]=left[i]*right[i];
            }
        }else {
            result[index]=left[index]*right[index];
        }
        return result;
    }
}
