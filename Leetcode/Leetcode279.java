
// Medium -> Perfect Squares
import java.util.Arrays;
public class Leetcode279 {
   class Solution {
    public static int numSquares(int n) {
        int []dp= new int[n+1];
        Arrays.fill(dp,-1);
        return solve(1,n,dp);
    }
    public static int solve(int idx,int num,int []dp){
        if(num==0){
            return 0;
        }
        if(num<0){
            return 1000000;
        }
        if(dp[num]!=-1){
            return dp[num];
        }
        int notpick=1+solve(idx,num-(idx*idx),dp);
        int pick=100000000;
        if((idx+1)*(idx+1)<=num) {
           pick=solve(idx + 1, num, dp);
        }
        return dp[num]=Math.min(pick,notpick);
    }

    public static void main(String[] args) {
        System.out.println(numSquares(999));
    }
}
}
