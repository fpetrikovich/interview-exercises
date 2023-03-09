public class ClimbStairs {
    public int climbStairs(int n) {
        /**
         Intution : the next distinict way of climbing stairs is euqal to the
         sum of the last two distinict way of climbing:
         distinct(n) = distinict(n-1) + distinict(n-2) */

        if (n < 2) return n;

        int[] dp = new int[n+1]; // dynamic programming

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public int climbStairsRec(int n) {
        if(n == 1) return 1; // There is one way to get to the 1
        if(n == 2) return 2; // there are 2 ways to get to the 2
        return climbStairs(n - 2) + climbStairs(n - 1);
    }
}
