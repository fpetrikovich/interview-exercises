public class FibonacciSeq {
    public int fib(int n) {
        /**
         Dynamic Programming == first broken down into sub-problems,
         the results are saved, and then the sub-problems are optimized
         to find the overall solution
         */

        if (n < 2) return n;

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
