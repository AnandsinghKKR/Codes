public class Leetcode1043 {
    class Solution {
        public int maxSumAfterPartitioning(int[] arr, int k) {
    //        Now converting into dp
            int n=arr.length;
            int dp[]=new int[arr.length+1];
            dp[n]=0;
            for(int idx=n-1;idx>=0;idx--){
                int len=0;
            int maxi=Integer.MIN_VALUE;
            int sum=0;
            int maxsum=Integer.MIN_VALUE;
            for(int i=idx;i<idx+k && i<arr.length;i++){ // trying all the partitions
                len++;
                maxi=Math.max(maxi,arr[i]);
                sum=len*maxi +dp[i+1];  // hetre
                maxsum=Math.max(maxsum,sum);
            }
            dp[idx]=maxsum;
            }
            return dp[0];
    //        return helper(0,k,arr);
        }
    //    public int helper(int idx,int k,int []arr){
    //        if(idx>=arr.length){
    //            return 0;
    //        }
    //        int len=0;
    //        int maxi=Integer.MIN_VALUE;
    //        int sum=0;
    //        int maxsum=Integer.MIN_VALUE;
    //        for(int i=idx;i<idx+k && i<arr.length;i++){ // trying all the partitions
    //            len++;
    //            maxi=Math.max(maxi,arr[i]);
    //            sum=len*maxi +helper(i+1,k,arr);  // hetre
    //            maxsum=Math.max(maxsum,sum);
    //        }
    //        return maxsum;
    //    }
    }
}
