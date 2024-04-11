package LC;

public class LC877StoneGame_I {

    boolean titForTat(int[] stones) {
        int N = stones.length;
        int[][] dp = new int[N + 1][N + 1];
        return dpHelper(stones, 0, N - 1, dp) > 0;
        // as alice start first so (-) meaning alice is doomed.
    }

    int dpHelper(int[] stones, int start, int end, int[][] dp) {
        if (start > end)
            return 0;
        if (dp[start][end] != 0)
            return dp[start][end];
        // max as have to find out the optimal for current player
        // (-) as two player . so current one gets and next state for
        // 2nd player and not added to current player.
        return dp[start][end] = Math.max(
                stones[start] - dpHelper(stones, start + 1, end, dp),
                stones[end] - dpHelper(stones, start, end - 1, dp));
    }

    public static void main(String[] args) {
        LC877StoneGame_I obj = new LC877StoneGame_I();

        System.out.println(obj.titForTat(new int[]{5, 3, 4, 5})); // true
        System.out.println(obj.titForTat(new int[]{3, 7, 2, 3})); // true
    }
}
