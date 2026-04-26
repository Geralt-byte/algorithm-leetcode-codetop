package codetop.page03.a20;

/**
 * @author mlei@xjtu
 * @description 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * @create 2026/4/26 14:28
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return new int[]{-1, -1};
        if (n == 1) return nums[0] == target ? new int[]{0, 0} : new int[]{-1, -1};
        int left = 0, right = n - 1, index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                if (mid == 0 || nums[mid - 1] < target) {
                    index = mid;
                    break;
                } else {
                    right = mid - 1;
                }
            }
        }
        if (index == -1) return new int[]{-1, -1};
        left = index;
        right = n - 1;
        int rightBound = index;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                if (mid == n - 1 || nums[mid + 1] > target) {
                    rightBound = mid;
                    break;
                } else {
                    left = mid + 1;
                }
            }
        }
        return new int[]{index, rightBound};
    }
}
