public class gfg7feb {
    class GfG {
        Node lca(Node root, int a, int b){
            
            if(root==null || root.data ==a || root.data == b){
                return root;
            }
            
            Node left = lca(root.left,a,b);
            
            Node right = lca(root.right,a,b);
            
            if(left==null){
                return right;
            }
            
            else if(right==null){
                return left;
            }
            else return root;
            
        }
        
        int distanceFromNode(Node root,int a){
            if(root==null){
                return -1;
            }
            
            if(root.data==a){
                return 0;
            }
            
            
            
            
            
            int left = distanceFromNode(root.left, a);
            int right = distanceFromNode(root.right, a);
            
            if(left!=-1){
                return 1 + left;
            }
            
            if(right!=-1){
                return 1+right;
            }
            
            return -1;
        }
        int findDist(Node root, int a, int b) {
            // Your code here
            
           if(root==null){
               return -1;
           }
           Node leastan = lca(root,a,b);
           
           int distx = distanceFromNode(leastan,a);
           int disty = distanceFromNode(leastan,b);
           
           return distx+disty;
           
           
        
           
           
        }
    }
}
