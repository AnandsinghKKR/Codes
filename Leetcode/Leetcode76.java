public class Leetcode76 {
    class Solution {
        public String minWindow(String s, String t) {
            if(s.length()==0 || t.length()==0 || s.length()<t.length()){
                return new String();
            }
            int[] map = new int[128];
            char[] sArray = s.toCharArray();
            char[] tArray = t.toCharArray();
    
            for(char i : tArray){
                map[i]++;
            }
            int left = 0;
            int right=0;
            int count = t.length();
            int minStart = 0;
            int minLength=Integer.MAX_VALUE;
            
            while(right<s.length()){
                if(map[sArray[right]] >0){
                    count--;
                }
                map[sArray[right]]--;
    
                while(count==0){
                    if(right-left+1 < minLength){
                        minLength = right-left+1;
                        minStart = left;
                    }
                    map[sArray[left]]++;
                    if(map[sArray[left]] > 0){
                        count++;
                    }
                    left++;
                }
                right++;
            }
            if(minLength>s.length()){
                return new String();
            }else{
                return s.substring(minStart, minStart+minLength);
            }
    
        }
    }
}
