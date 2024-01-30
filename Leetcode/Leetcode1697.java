// Leetcode Hard  -> 1697. Checking Existence of Edge Length Limited Paths

import java.util.*;
public class Leetcode1697 {
class disjointset{
    List<Integer>size =new ArrayList<>();
    List <Integer>parent=new ArrayList<>();
    public disjointset(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            size.add(1);
        }
    }
    public int findpar(int node){
        if(node==parent.get(node)){
            return node;
        }
        int ulp=findpar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public void unionbysize(int u,int v){
        int ulpu=findpar(u);
        int ulpv=findpar(v);
        if(ulpu==ulpv){
            return;
        }
        if(size.get(ulpu)<size.get(ulpv)){
            parent.set(ulpu,ulpv);
            size.set(ulpv,size.get(ulpu)+size.get(ulpv));
        }
        else{
            parent.set(ulpv,ulpu);
            size.set(ulpu,size.get(ulpu)+size.get(ulpv));
        }
    }
}
class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {

        Arrays.sort(edgeList, Comparator.comparingInt(entry -> entry[2]));
        // before sorting store index in it.
        int[][] modifiedQueries = new int[queries.length][];
        for (int i = 0; i < queries.length; i++) {
            int newSize = queries[i].length + 1;
            modifiedQueries[i] = new int[newSize];
            System.arraycopy(queries[i], 0, modifiedQueries[i], 0, queries[i].length);
            modifiedQueries[i][newSize - 1] = i; // Place the index in the new slot
        }

        Arrays.sort(modifiedQueries, Comparator.comparingInt(entry -> entry[2]));

        disjointset ds=new disjointset(n);

        boolean []ans=new boolean[queries.length];
    int i=0;
        for(int j=0;j<modifiedQueries.length;j++) {
            int wtquery=modifiedQueries[j][2];

            while (i< edgeList.length && edgeList[i][2]<wtquery) {
                int u = edgeList[i][0];
                int v = edgeList[i][1];
                int paru = ds.findpar(u);
                int parv = ds.findpar(v);
                if (parv != paru) 
                    ds.unionbysize(u, v);
                    i++;
                
            }
            int paruquery=ds.findpar(modifiedQueries[j][0]);
            int parvquery=ds.findpar(modifiedQueries[j][1]);
            if (paruquery == parvquery) {
                ans[modifiedQueries[j][3]] = true;
            }
        }
        return ans;
    }
}
}
