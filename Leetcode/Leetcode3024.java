public class Leetcode3024 {
    class Solution {
        public String triangleType(int[] nums) {
        int a=nums[0];
        int b=nums[1];
        int c=nums[2];
        if(a==b && b==c){
            if(((a+b)<=c)||((b+c)<=a)|| ((a+c)<=b)){
                return "none";
            }
            else {
                return "equilateral";
            }
        }
        else if(a==b || b==c || a==c){
            if(((a+b)<=c)||((b+c)<=a)|| ((a+c)<=b)){
                return "none";
            }
            else {
                return "isosceles";
            }
        }
        else{
            if(((a+b)<=c)||((b+c)<=a)|| ((a+c)<=b)){
                return "none";
            }
            else {
                return "scalene";
            }
        }
        }
    }
}
