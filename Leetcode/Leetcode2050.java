// Parallel Course 3 -> Leetcode Hard


import java.util.*;
public class Leetcode2050 {
    
public int minimumTime(int n, int[][] relations, int[] time) {
// 0- indexing
     int []indegree=new int[n];
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<relations.length;i++){
            adj.get(relations[i][0]-1).add(relations[i][1]-1);
            indegree[relations[i][1]-1]++;
        }


        Queue<Integer>q=new ArrayDeque<>();
         int[] mtime =new int[n];
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
                mtime[i]=time[i];
            }
        }
       
        int max=0;
        while(!q.isEmpty()){
            int temp=q.poll();
            for(int v: adj.get(temp)){
                mtime[v]=Math.max(mtime[v],time[temp]+mtime[temp]);
                indegree[v]--;
                if(indegree[v]==0){
                    q.add(v);
                }
            }
        }
        for(int i=0;i<mtime.length;i++){
            max=Math.max(max,mtime[i]);
        }
        return max;
    }
}
