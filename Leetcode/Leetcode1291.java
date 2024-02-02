// 1291. Sequential Digits

import java.util.*;
public class Leetcode1291 {
class Solution {
    List<Integer>ans=new ArrayList<>();
    public List<Integer> sequentialDigits(int low, int high) {
        for(int i=1;i<=8;i++){
            solve(i, String.valueOf(i),low,high);
        }
        Collections.sort(ans);
        return ans;
    }
    public void solve(int num,String s,int low,int high){

        int number=Integer.parseInt(s);
        if(number>high){
            return ;
        }
        if(number>=low){
            ans.add(number);
        }
        if(num<=8) {
            solve(num + 1, s + (num + 1), low, high);
        }
    }
}
}
