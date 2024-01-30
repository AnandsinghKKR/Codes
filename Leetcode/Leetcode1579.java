import java.util.*;
public class Leetcode1579 {
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
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges,(entry1, entry2) -> Integer.compare(entry2[0], entry1[0]));
        // array is sorted
        disjointset dsalice=new disjointset(n);
        disjointset dsbob=new disjointset(n);

        int ans=0;
        int aliceedge=0;
        int bobedge=0;
        int removeedges=0;
        for(int i=0;i<edges.length;i++){
            int type=edges[i][0];
            int u=edges[i][1];
            int v=edges[i][2];
            if(type==3){  // for both
                int paru=dsalice.findpar(u);
                int parv=dsalice.findpar(v);
                if(paru!=parv){
                    dsalice.unionbysize(u,v);
                    dsbob.unionbysize(u,v);
                    aliceedge++;
                    bobedge++;
                }
                else{
                    removeedges++;
                }
            }

            else if(type==2){ // for bob only
                int paru=dsbob.findpar(u);
                int parv=dsbob.findpar(v);
                if(paru!=parv){
                    dsbob.unionbysize(u,v);
                    bobedge++;
                }
                else{
                    removeedges++;
                }
            }
            else{
                int paru=dsalice.findpar(u);
                int parv=dsalice.findpar(v);
                if(paru!=parv){
                    dsalice.unionbysize(u,v);
                    aliceedge++;
                }
                else{
                    removeedges++;
                }
            }
        }
        if (aliceedge==n-1 && bobedge==n-1){
            return removeedges;
        }else
        return -1;
    }
}
}
