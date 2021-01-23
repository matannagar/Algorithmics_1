package tests;

public class LCS_size_of_k {

        static int N = 30;

        // Return Minimum cost to make LCS of length k
        static int solve(char X[], char Y[], int l, int r,
                         int k, int[][][] dp)
        {
            // If k is 0.
            if (k == 0)
            {
                return 0;
            }

            // If length become less than 0, return
            // big number.
            if (l < 0 | r < 0)
            {
                return (int) 1e9;
            }

            // If state already calculated.
            if (dp[l][r][k] != -1)
            {
                return dp[l][r][k];
            }

            // Finding the cost
            int cost = (X[l] - 'a') ^ (Y[r] - 'a');

            // Finding minimum cost and saving the state value
            return dp[l][r][k] = Math.min(Math.min(cost +
                            solve(X, Y, l - 1, r - 1, k - 1, dp),
                    solve(X, Y, l - 1, r, k, dp)),
                    solve(X, Y, l, r - 1, k, dp));
        }

        // Driver code
        public static void main(String[] args)
        {
            char X[] = "abble".toCharArray();
            char Y[] = "pie".toCharArray();
            int n = X.length;
            int m = Y.length;
            int k = 2;

            int[][][] dp = new int[N][N][N];
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    for (int l = 0; l < N; l++)
                    {
                        dp[i][j][l] = -1;
                    }
                }
            }
            int ans = solve(X, Y, n - 1, m - 1, k, dp);

            System.out.println(ans == 1e9 ? -1 : ans);
        }
    }

// This code contributed by Rajput-Ji

