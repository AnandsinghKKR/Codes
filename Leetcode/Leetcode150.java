// 150. Evaluate Reverse Polish Notation

import java.util.*;
public class Leetcode150 {
   
class Solution {
    public int evalRPN(String[]s) {
    Stack<Integer>st= new Stack<>();
    for(int i=0;i<s.length;i++){

        if(s[i].length()==1 &&(s[i].charAt(0)=='*' || s[i].charAt(0)== '/' || s[i].charAt(0)=='-'|| s[i].charAt(0)=='+')){
                int num1=st.pop();
                int num2=st.pop();
                if(s[i].charAt(0)=='*'){
                    st.push(num1*num2);
                }
                else if(s[i].charAt(0)=='/'){
                    st.push(num2/num1);
                }
                else if(s[i].charAt(0)=='+'){
                    st.push(num1+num2);
                }
                else {
                    st.push(num2-num1);
                }
        }
        else{
            int intValue1 = Integer.parseInt(s[i]);
            st.push(intValue1);
        }
    }
    return st.pop();
    }
}
}
