class Solution
{
    public char nthCharacter(String s, int r, int n)
    {
        if (r==0) {
            return s.charAt(n);
        }
        int num =1;
        for(int i=0; i<r; i++) num*=2;
        int or=n/num;
        int sub=n%num;
        if (s.charAt(or)=='1') {
            return nthCharacter("10", r-1, sub);
        } else{
            return nthCharacter("01", r-1, sub);
        }
    }
}