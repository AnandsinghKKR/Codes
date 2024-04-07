public class Leetcode678 {
    class Solution {
        class pair{
         int idx;
         char c;
         public pair(char c,int idx){
             this.c=c;
             this.idx=idx;
         }
     }
      public  boolean checkValidString(String s) {
      Stack<pair>st = new Stack<pair>();
      Stack<pair> star= new Stack<pair>();
  
      for(int i=0;i<s.length();i++){
          char tc=s.charAt(i);
          if(tc=='('){
              st.push(new pair('C',i));
          }
          else if(tc==')'){
              if(!st.isEmpty()){
                  st.pop();
              }
              else if(!star.isEmpty()){
                  star.pop();
              }
              else{
                  return false;
              }
          }
          else{
              star.push(new pair('*',i));
          }
      }
      // when st and star ,Stack is not empty;
          if(st.size()>star.size()){
              return false;
          }
          else {
              while (!st.isEmpty()) {
                  int ii = st.pop().idx;
                  int jj = star.pop().idx;
                  if (ii > jj) {
                      return false;
                  }
              }
          }
          return true;
      }
  }
}
