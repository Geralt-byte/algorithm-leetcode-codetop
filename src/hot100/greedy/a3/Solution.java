package hot100.greedy.a3;

/**
 * @author mlei@xjtu
 * @description 给定一个长度为 n 的 0 索引整数数组 nums。初始位置在下标 0。
 * 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在索引 i 处，你可以跳转到任意 (i + j) 处：
 * 0 <= j <= nums[i] 且
 * i + j < n
 * 返回到达 n - 1 的最小跳跃次数。测试用例保证可以到达 n - 1。
 * @create 2026/3/26 15:55
 */
public class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int index = 0;
        int next = index;
        int count = 0;
        while (index < nums.length) {
            int max=index;
            for (int i = 1; i <= nums[index]; i++) {
                int nextIndex =i + index;
                if(nextIndex>=nums.length-1) return count+1;
                if (max < nums[nextIndex] + nextIndex) {
                    max = nums[nextIndex] + nextIndex;
                    next = nextIndex;
                }
            }
            index = next;
            count++;
        }
        return count;
    }
}
