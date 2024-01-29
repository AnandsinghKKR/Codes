public class Leetcode3021 {
    class Solution {
        public long flowerGame(int n, int m) {
            long even_on_n=n/2;
            long odd_on_n=(n+1)/2;

            long even_on_m=m/2;
            long odd_on_m=(m+1)/2;

            long ans= even_on_m*odd_on_n+even_on_n*odd_on_m;
            return ans;
        }
    }
}
