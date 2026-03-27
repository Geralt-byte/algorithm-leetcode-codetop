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
public class Solution1 {
    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        //max,当前遍历点可以达到的最远距离，limit,限制当前遍历点达到上一跳的最远距离再跳跃
        int max=0,limit=0,count=0;
        //发现一个可以跳跃的点以后再更新count，也就是说最多到达倒数第二个位置
        for (int i = 0; i < nums.length-1; i++) {
            //不断更新可以达到的最远距离
            max=Math.max(max,nums[i]+i);
            //当前遍历点到达了上一跳可以到达的最远距离，再更新limit和count
            if(i==limit){
                //limit更新为跳过去后可以到达的最远距离
                limit=max;
                count++;
            }
        }
        return count;
    }
}
