package hot100.select.a4;

/**
 * @author mlei@xjtu
 * @description 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 向左旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
 * （下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 下标 3 上向左旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * @create 2026/3/24 18:00
 */
public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1) return target == nums[0] ? 0 : -1;
        //寻找第一段的右端点
        int partARight = 0;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low + 1) / 2;
            //运气好恰好碰到了target，直接返回
            if (nums[mid] == target) return mid;
            //当mid大于第一个元素时
            else if (nums[mid] > nums[0]) {
                //mid处于最后说明是特殊情况，数组是从0开始旋转的，等于没有旋转
                //或者mid的后一个元素小于第一个元素，说明找到了边界
                if (mid == nums.length - 1 || nums[mid + 1] < nums[0]) {
                    //这两种情况下mid为第一段的右端点
                    partARight = mid;
                    break;
                }
                //否则继续向右查找
                low = mid + 1;
            }
            //当mid小于第一个元素时
            else if (nums[mid] < nums[0]) {
                //因为数组元素互不相同，且开头剪枝了数组长度为1的情况，所以数组长度至少为2，不存在mid=第一个元素的情况
                //mid-1==第一个元素说明第一段只有一个元素
                if (nums[mid - 1] >= nums[0]) {
                    //大于或等于情况下mid-1都为第一段的右端点
                    partARight = mid - 1;
                    break;
                }
                //虽然这里指针向左移动了，但是仍然不会出现mid=第一个元素的情况，因为进入这个分支的条件是nums[mid] < nums[0]，进入了
                //这个分支就表明了一定在k>0的位置发生的旋转，那么一定会先找到nums[mid - 1] >= nums[0]的情况
                high = mid - 1;
            }
        }
        //k=0发生旋转
        if (partARight == nums.length - 1) {
            low = 0;
            high = nums.length - 1;
        }
        //k>0旋转
        //在第二段
        else if (target < nums[0]) {
            low = partARight + 1;
            high = nums.length - 1;
        }
        //在第一段
        else if (target > nums[nums.length - 1]) {
            low = 0;
            high = partARight;
        }
        //target不在范围内
        if(target < nums[low] || target > nums[high]) return -1;
        //在对应段落查找
        while (low <= high) {
            int mid = low + (high - low + 1) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else return mid;
        }
        return -1;
    }
}
