public class Leetcode3025 {
    class Solution {
        public  int numberOfPairs(int[][] points) {
            int ans=0;
            for(int i=0;i<points.length;i++){
                int x1=points[i][0];
                int y1=points[i][1];
    
                for(int j=0;j< points.length;j++){
                    int x2=points[j][0];
                    int y2=points[j][1];
    
                    if((j!=i)&&(x1<=x2) && (y1>=y2)) {
                        boolean b=false;
                        for (int k = 0; k < points.length; k++) {
                            int kx3=points[k][0];
                            int ky3=points[k][1];
                            if ((k != i) && (k != j))
                            {
                                if((Math.min(x1,x2)<=kx3 && Math.max(x2,x1)>=kx3)&&(Math.min(y1,y2)<=ky3 && Math.max(y2,y1)>=ky3)){
                                    b=true;
                                    break;
                                }
                            }
                        }
                        if(!b){
                            ans++;
                        }
                    }
                }
            }
            return ans;
        }
    }
}
