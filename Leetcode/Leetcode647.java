// 647. Palindromic Substrings


import java.util.Arrays;
public class Leetcode647 {
 
public class Solution {
public int countSubstrings(String s) {
        int count = 0;
        int []dp=new int [s.length()+1];
    Arrays.fill(dp,-1);
        return palindromicSubstring(s,"",0, count,dp);
        }

public  int palindromicSubstring(String s, String result, int index, int count, int[]dp){
        if(index == s.length()){
        return count;
        }
if(dp[index]!=-1){
    return dp[index];
}
        for(int i=index;i<s.length();i++){
        if(isPalindrome(index, i, s)){
        //s.substring(index, i+1) will be the palindromic string
        count++;
        }
        }
        return dp[index]=palindromicSubstring(s, result, index+1, count,dp);
        }

public  boolean isPalindrome(int start, int end,String s){
        while(start<=end){
        if(s.charAt(start)==s.charAt(end)){
        start++;
        end--;
        }else{
        return false;
        }
        }
        return true;
        }
        }
}
