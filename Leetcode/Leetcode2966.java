// 2966. Divide Array Into Arrays With Max Difference  (sliding window +sorting)
import java.util.*;
public class Leetcode2966 {
class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int [][]ans_array= new int[nums.length/3][3];
        Arrays.sort(nums);

        int i=0;int j=0;
        int min=Integer.MAX_VALUE;
        int m=0;
        int n=0;
        while(j<nums.length){
            if(j-i>2){
                n++;
                m=0;
                i=j;
                min=Integer.MAX_VALUE;
            }
            min = Math.min(min, nums[j]);
            if (nums[j] - min > k) {
                return new int[][]{};
            }
            
            ans_array[n][m++] = nums[j];
            j++;
        }
        return ans_array;
    }
}
}
