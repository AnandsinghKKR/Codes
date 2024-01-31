// 739. Daily Temperatures (Just like Next greater element ) using Stack

import java.util.Stack;
public class Leetcode739 {
    class Solution {
    
        public int[] dailyTemperatures(int[] temperatures) {
            int []ansarray=new int[temperatures.length];
            Stack<int []>st=new Stack<>();
    
            for(int i=0;i<temperatures.length;i++){
                if(st.size()==0){
                    st.push(new int []{temperatures[i],i});
                }
                else if(temperatures[i]>st.peek()[0]){
                    while(st.size()>0 && temperatures[i]>st.peek()[0]){
                        ansarray[st.peek()[1]]=i-st.peek()[1];
                        st.pop();
                    }
                    st.push(new int []{temperatures[i],i});
                }
                else{
                    st.push(new int[]{temperatures[i],i});
                }
            }
            return ansarray;
        }
    }
}
