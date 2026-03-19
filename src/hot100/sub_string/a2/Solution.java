package hot100.sub_string.a2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mlei@xjtu
 * @description 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * @create 2026/3/19 16:10
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result=new int[nums.length-k+1];
        int index=0;
        Deque<Integer> deque=new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if(!deque.isEmpty()&&deque.peekFirst()<i-k+1){
                deque.pollFirst();
            }
            while (!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }
            deque.offer(i);
            if(i>=k-1){
                result[index++]=nums[deque.getFirst()];
            }
        }
        return result;
    }
}
