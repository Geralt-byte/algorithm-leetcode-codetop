package hot100.select.a1;

/**
 * @author mlei@xjtu
 * @description 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * @create 2026/3/24 17:39
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int low=0,high=nums.length-1;
        while (low<=high){
            int mid=low+(high-low+1)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) high=mid-1;
            else low=mid+1;
        }
        return high;
    }
}
