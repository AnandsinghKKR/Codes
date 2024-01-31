// 2858. Minimum Edge Reversals So Every Node Is Reachable

import java.util.*;
public class Leetcode2858 {
class Solution {
    int []added_edge;
    int ans;
    public int[] minEdgeReversals(int n, int[][] edges) {
        ArrayList<ArrayList<int []>>adj=new ArrayList<>();
        added_edge=new int[n];
        Arrays.fill(added_edge,-1);
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new int []{edges[i][1],0});
            adj.get(edges[i][1]).add(new int []{edges[i][0],1});  // psedo edge added
        }
        boolean []vis=new boolean[n];
        solve(0,vis,adj);
        added_edge[0]=ans;
        // now to fill the array completely
        dfs(0,adj);
        return added_edge;

    }
    public void solve(int src,boolean []vis,ArrayList<ArrayList<int []>>adj){

        vis[src]=true;
       
        for(int v[]:adj.get(src)){
            if(!vis[v[0]]){
                if(v[1]==1){
                  ans++;
                    solve(v[0],vis,adj);
                }
                else{
                    solve(v[0],vis,adj);
                }
            }
        }
        return ;
    }
    public void dfs(int src,ArrayList<ArrayList<int []>>adj){

        for(int v[]:adj.get(src)){
            if(added_edge[v[0]]==-1){
                if(v[1]==1){
                    added_edge[v[0]]=added_edge[src]-1;
                }
                else{
                    added_edge[v[0]]=added_edge[src]+1;
                }
                dfs(v[0],adj);
            }
        }
    }
}
}
