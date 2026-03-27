package hot100.skill.a5;

/**
 * @author mlei@xjtu
 * @description 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 * @create 2026/3/26 19:56
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        //环形链表问题
        int slow=0,fast=0;
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (slow != fast);
        fast=0;
        while (slow!=fast){
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
