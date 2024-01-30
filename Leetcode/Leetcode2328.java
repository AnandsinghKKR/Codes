//2328. Number of Increasing Paths in a Grid    (graph + dp)

import java.util.Arrays;
public class Leetcode2328 {
    class Solution {
    int[][] dp;
    int mod = (int) 1e9+7;
    public int countPaths(int[][] grid) {
        int res = 0;
        dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) Arrays.fill(dp[i], -1);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                res += f(i, j, grid); 
                res %= mod;
            }
        }
        return (res + grid.length*grid[0].length) % mod;
    }
    
    private int f(int i, int j, int[][] grid) {
        
        if (dp[i][j] != -1) return dp[i][j];
        
        int count = 0;
        
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) return 0;
        
        // Up
        if(i > 0 && grid[i][j] < grid[i-1][j])
            count += f(i-1, j, grid) + 1;
        
        // Down
        if(i < grid.length-1 && grid[i][j] < grid[i+1][j])
            count += f(i+1, j, grid) + 1;        
        
        // Left
         if(j > 0 && grid[i][j] < grid[i][j-1])
            count += f(i, j-1, grid) + 1;
        
        // Right
        if(j < grid[i].length-1 && grid[i][j] < grid[i][j+1])
            count += f(i, j+1, grid) + 1;
        
        count = count % mod;
        dp[i][j] = count;
        return count;
    }
}
}
