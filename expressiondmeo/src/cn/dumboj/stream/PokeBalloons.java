package cn.dumboj.stream;
/**
 * From：LeetCode。
 * */
public class PokeBalloons {
    /**
     * todo:动态规划
     *      A.每戳破一个气球 nums[i]，得到的分数和该气球相邻的气球 nums[i-1] 和 nums[i+1] 是有相关性的
     *      B.没有气球戳破case-戳破气球 ij开区间，(i,j)可以获得的最高分数为
     *        dp[i][j] = 0，0 <= i <= n+1, j <= i+1  （i，j）没气球可戳
     *      C.状态转移方程+穷举图例见 pad-211122.Note4、Note5、Note6
     *
     * */
    public int DynamicProgramming(int[] nums) {
        int n = nums.length;

        //add bother sides
        int [] points = new int[n+2];
        points[0] = points[n+1] = 1;
        for (int i = 1; i <= n; i++) {
            points[i] = nums[i - 1];
        }
        //base case  init to zero
        int[][] dp = new int[n + 2][n + 2];
//        状态转移
        //i Lower -> Top
        for (int i = n; i >= 0 ; i--) {
            //j Left -> Right
            for (int j = i + 1; j < n+2; j++) {
                // final poke balloon ?
                for (int k = i+1; k < j; k++) {
                    dp[i][j] = Math.max(
                            dp[i][j],
                            dp[i][k] + dp[k][j] + points[i] * points[j] * points[k]
                    );
                }
            } 
        }
        return dp[0][n + 1];
    }
}
