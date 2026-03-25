package hot100.select.a3;

/**
 * @author mlei@xjtu
 * @description 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * @create 2026/3/24 18:00
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0) return new int[]{-1,-1};
        int start=-1,end=-1;
        int low=0,high=nums.length-1;
        //查找左边界
        while (low<=high){
            int mid=low+(high-low+1)/2;
            if(nums[mid]>target){
                high=mid-1;
            }else if(nums[mid]<target){
                low=mid+1;
            }else {
                //当mid处于最左侧或前一个数小于target时，退出循环，找到start
                if(mid==0||nums[mid-1]<target){
                    start=mid;
                    break;
                }else {
                    //继续寻找更小索引的target
                    high=mid-1;
                }
            }
        }
        //没找到左边界直接返回
        if(start==-1) return new int[]{-1,-1};
        //查找右边界
        low=start;
        high=nums.length-1;
        while (low<=high){
            int mid=low+(high-low+1)/2;
            //在右边不可能存在小于target1的情况
            if(nums[mid]>target){
                high=mid-1;
            }else {
                //当mid处于最右侧或后一个数大于target时，退出循环，找到end
                if(mid==nums.length-1||nums[mid+1]>target){
                    end=mid;
                    break;
                }
                //继续寻找更大索引的target
                else low=mid+1;
            }
        }
        return new int[]{start,end};
    }
}
