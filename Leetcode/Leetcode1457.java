// Medium  1457. Pseudo-Palindromic Paths in a Binary Tree

 class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
public class Leetcode1457 {
    public int pseudoPalindromicPaths (TreeNode root) {
        int num[]=new int[10];
        return solve(root,num);
    }
    public int solve(TreeNode node,int []num){
        num[node.val]++;
        if(node.left==null && node.right==null){
            //check array
            int oddcnt=0;
            for(int i=0;i<num.length;i++){
                if(num[i]%2 ==1){
                    oddcnt++;
                }
            }
            num[node.val]=num[node.val]-1;
            if(oddcnt==1 | oddcnt==0){
                return 1;
            }
            else{
                return 0;
            }
        }
        int left=0;
        if(node.left!=null){
            left=solve(node.left,num);
        }
        int right=0;
         if(node.right!=null){
            right=solve(node.right,num);
        }
        num[node.val]--;
        return left + right;
    }
}