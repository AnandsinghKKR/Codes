// 664. Strange Printer  (tough question of dp)

import java.util.Arrays;
public class Leetcode664 {
class Solution {
    public int strangePrinter(String s) {
        int[][]dp=new int[s.length()+1][s.length()+1];
        for (int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,s.length()-1,s,dp);
    }
    public int solve(int l,int r,String s ,int [][]dp){
        if(l==r){
            return 1;
        }
        if(l>r){
            return 0;
        }
        if(dp[l][r]!=-1){
            return dp[l][r];
        }
        int i=l+1;
        while(i<=r && s.charAt(i)==s.charAt(l) ){
            i++;
        }
        int first=1+solve(i,r,s,dp);
        int greedy_ans=Integer.MAX_VALUE;
        for(int j=i;j<=r;j++){
            if(s.charAt(j)==s.charAt(l)){
                int ans=solve(i,j-1,s,dp)+solve(j,r,s,dp);
                greedy_ans=Math.min(ans,greedy_ans);
            }
        }
        return dp[l][r]=Math.min(first,greedy_ans);
    }
}

// abcabc
// abcabc;
}
