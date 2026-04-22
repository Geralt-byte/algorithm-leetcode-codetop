package codetop.page03.a1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mlei@xjtu
 * @description 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * @create 2026/4/21 08:20
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) return nums;
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            //移除窗口外的元素
            if (!deque.isEmpty() && deque.getFirst() < i - k + 1) {
                deque.pollFirst();
            }
            //维持单调递减队列
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            //计算滑动窗口最大值
            if (i >= k - 1) {
                result[index++] = nums[deque.getFirst()];
            }
        }
        return result;
    }
}
