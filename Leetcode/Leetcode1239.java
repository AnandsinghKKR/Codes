import java.util.*;
public class Leetcode1239 {
    public static int maxLength(List<String> arr) {
        return solve(0,"",arr);
    }
    public static int solve(int idx,String sofar,List<String>arr){

        if(idx>=arr.size()){
            return sofar.length();
        }
        int nottake=solve(idx+1,sofar,arr);
        char[]sf=new char[26];
        char[] ns=new char[26];
        int take=0;
        boolean b=false;
        String st=arr.get(idx);
        for(int i=0;i<st.length();i++){
            ns[st.charAt(i)-'a']++;
        }
        for(int i=0;i<sofar.length();i++){
            if(sf[sofar.charAt(i)-'a']==0){
                sf[sofar.charAt(i)-'a']++;
            }
        }
        for(int i=0;i<26;i++){
            if ((sf[i] == 1 && ns[i] == 1) || ns[i] > 1 || sf[i] > 1) {
                b = true;
                break;
            }
        }
        if(b){
            take=solve(idx+1,sofar,arr);
        }
        else{
            take=solve(idx+1,sofar+st,arr);
        }
        return Math.max(take,nottake);
    }

    public static void main(String[] args) {
        List<String>s=new ArrayList<>();
        s.add("cha");
        s.add("r");
        s.add("act");
        s.add("ers");
        System.out.println(maxLength(s));
    }
}