
package gfg;

public class atoi {
    class Solution
{
    static int atoi(String s) {
        // Your code here
        int ans=0;

        char symbol='+';
        int length=s.length()-1;

        for(int i=0;i<s.length();i++){
            int val=s.charAt(i)-'0';
            if(i==0 &&(s.charAt(i)=='+' || s.charAt(i)=='-')){
                symbol= s.charAt(i);
                length--;
            }
            else if(val<=9 && val >=0){
                    ans= (int) (ans+Math.pow(10,length)*val);
                    length--;
            }
            else{
                return -1;
            }
        }

        if(symbol=='-'){
            return ans*(-1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(atoi("21a"));
    }
}
}
