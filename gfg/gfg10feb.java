// Number of paths in a matrix with k coins

public class gfg10feb {
    class Solution {
    
        long solve(int i, int j, int val, int n, int k, int [][]arr, long [][][]dp) {
            if(i == n - 1 && j == n - 1 && val + arr[i][j] == k) 
                return 1;
            
            if(i >= n || j >= n || i < 0 || j < 0 || val > k)
                return 0;
                
            if(dp[i][j][val] != -1)
                return dp[i][j][val];
                
            long ans = 0;
            if(i + 1 < n)
                ans += solve(i + 1, j, val + arr[i][j], n, k, arr, dp);
            
            if(j + 1 < n)
                ans += solve(i, j + 1, val + arr[i][j], n, k, arr, dp);
                
            return dp[i][j][val] = ans;
        }
        
        long numberOfPath(int n, int k, int [][]arr) {
            long dp[][][] = new long[n][n][k + 1];
            for(int i = 0; i < n; i++)  
                for(int j = 0; j < n; j++)
                    for(int m = 0; m <= k; m++)
                        dp[i][j][m] = -1;
                        
            return solve(0, 0, 0, n, k, arr, dp);
        }
    }

}
