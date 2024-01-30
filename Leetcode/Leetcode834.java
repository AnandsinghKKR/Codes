// 834. Sum of Distances in Tree   (Good Question of graph + distance of child+ Number of child of each parent)

import java.util.*;
public class Leetcode834 {
class Solution {
int []countchild;
int []result;
int sum;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        // My First thought's
        // floyd warshall -> from each node to every other node than it   will take o(n^3)T.C
        // definetly precomputation is there
        // applying bfs from each node to find distance

        // means no cycle is there
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean []b=new boolean[n];
        countchild=new int[n];
        result=new int[n];
        solve(0,0,adj,b);

        // Now I need Count of childs
        b=new boolean[n];
        result=new int[n];
        result[0]=sum;
        dfs(0,adj,n,b);
        // now fill the answer in another dfs

        return result;
    }
    public void solve(int src,int dis,ArrayList<ArrayList<Integer>>adj,boolean []b){
        b[src]=true;
        sum+=dis;

            for (int v : adj.get(src)) {
                if (!b[v]) {
                    solve(v, dis + 1, adj, b);
                    countchild[src]+=countchild[v];
                }
            }
        countchild[src]++;
        return ;
    }
    public void dfs(int parent,ArrayList<ArrayList<Integer>>adj,int n,boolean b[]){
        b[parent]=true;
        for(int v:adj.get(parent)){
            if(!b[v]){
                result[v]=result[parent]-countchild[v]+n-countchild[v];
                dfs(v,adj,n,b);
            }
        }
    }
}
}
