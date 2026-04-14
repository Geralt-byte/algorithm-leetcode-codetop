package codetop.page01.a8;

import java.util.Random;

/**
 * @author mlei@xjtu
 * @description Solution
 * @create 2026/4/13 14:25
 */
public class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(nums, left, right);
            quickSort(nums, left, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        //随机选择一个数当作分治点
        Random random = new Random();
        int pivotIndex = left + random.nextInt(right - left + 1);

        int temp = nums[pivotIndex];
        nums[pivotIndex] = nums[left];
        nums[left] = temp;

        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) left++;
            nums[right] = nums[left];

        }
        nums[left] = pivot;
        return left;
    }
}
