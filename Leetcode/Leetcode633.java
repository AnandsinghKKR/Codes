import java.util.*;
public class Leetcode633 {
    class Solution {
     
      
            public boolean judgeSquareSum(int c) {
                // if(c<=1){return true;}
                      long start =0;
                long end=(long)Math.sqrt(c);
                long mid=0;
                while(start<=end){
                    mid=start*start+end*end;
                    if((mid) >c){
                        end--;
                    }
                        else if((mid) <c){
                            start++;
                        }
                    else if(mid==c){
                        return true;
                    }
                }
              return false;
            }
        }
    }