// hard but easy approaach (must Try !!)

public class Leetcode765 {
    class Solution {
        public int minSwapsCouples(int[] a) {
              int n = a.length, count=0;
              int[] revIndex = new int[n];
              for(int i=0; i < n; i++)
                  revIndex[a[i]] = i;
              for(int i=0; i < n; i+=2){
                  int partner = a[i] % 2 == 0 ? a[i]+1 : a[i]-1;
                  if(a[i+1] != partner){
                      ++count;
                      //fix partner position
                      int tmp = a[i+1], j = revIndex[partner];
                      a[i+1] = a[j];
                      a[j] = tmp;
                      //fix revIndex
                      int tmp2 = revIndex[tmp];
                      revIndex[tmp] = revIndex[partner];
                      revIndex[partner] = tmp2;
                  }            
              }
              return count;
          }
      }
}
