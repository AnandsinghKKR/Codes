package gfg;

public class LCSof3 {
    class Solution
{
    int LCSof3(String A, String B, String C, int n1, int n2, int n3)

    {
        int dp[][][]=new int[n1+1][n2+1][n3+1];
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                for(int k=0;k<n3;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return LCS(A,B,C,n1-1,n2-1,n3-1,dp);

    }
    public static int LCS(String A,String B,String C,int i,int j,int k,int dp[][][]){
        if(i<0||j<0||k<0){
            return 0;
        }
        if(dp[i][j][k]!=-1){
            return dp[i][j][k];
        }
        if(A.charAt(i)==B.charAt(j)&&B.charAt(j)==C.charAt(k)){
            return dp[i][j][k]= LCS(A,B,C,i-1,j-1,k-1,dp)+1;
        }
        else{
            int ans1=LCS(A,B,C,i-1,j,k,dp);
            int ans2=LCS(A,B,C,i,j-1,k,dp);
            int ans3=LCS(A,B,C,i,j,k-1,dp);
            int ans=Math.max(ans1,Math.max(ans2,ans3));
            return dp[i][j][k]= ans;
        }
    }   
}
}
