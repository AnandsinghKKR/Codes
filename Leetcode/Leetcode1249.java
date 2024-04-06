public class Leetcode1249 {
    class Solution {
        class pair{
         char c;
         int idx;
         public pair(char c,int idx){
             this.c=c;
             this.idx=idx;
         }
     }
     public String minRemoveToMakeValid(String s) {
     Stack<pair>st=new Stack<>();
         StringBuilder ans= new StringBuilder();
         for(int i=0;i<s.length();i++){
             char t=s.charAt(i);
 
             if(t=='('){
 //                if(st.isEmpty()) {
                     st.push(new pair(t, ans.length()));
 //                }
             }
             else if(t==')'){
                 // now add it in another data structure
                 if(!st.isEmpty()) {
                     int ii = st.pop().idx;
                     ans.append(')');
                     ans.insert(ii, '(');
                 }
             }
             else{
                 ans.append(t);
             }
         }
         return ans.toString();
     }
 }
}
