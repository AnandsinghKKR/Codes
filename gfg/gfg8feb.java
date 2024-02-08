package gfg;

public class gfg8feb {
    /* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution
{
    int curr_height=-1;
    int ans=1;
    boolean check(Node root)
    {
        // Your code here
       solve(0,root);
        if(ans==0){
            return false;
        }return true;

    }
    void solve(int h,Node node){
        if(node==null){
            return;
        }
        if(ans==0){
            return;
        }
        if(node.left==null && node.right==null){
           if(curr_height==-1){
                curr_height=h;
           }
           else{
               if(curr_height!=h){
                   ans=0;
               }
           }
        }
        solve(h+1,node.left);
        solve(h+1,node.right);

    }
}
}
