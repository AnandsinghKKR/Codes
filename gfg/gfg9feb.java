package gfg;

public class gfg9feb {
    class Solution
    {
        //Function to check whether all nodes of a tree have the value
        //equal to the sum of their child nodes.
        public static int isSumProperty(Node root)
        {
            // add your code here
            return solve(root);
    
        }
        public static int solve(Node node) {
            if (node.left == null && node.right == null) {
                return 1;
            }
            int data = 0;
            if (node.left != null) {
                data += node.left.data;
            }
            if (node.right != null) {
                data += node.right.data;
            }
            if (data == node.data) {
                int l = 1;
                if (node.left != null) {
                    l = solve(node.left);
                }
                int r = 1;
                if (node.right != null) {
                    r = solve(node.right);
                }
    
                if (l == 0 || r == 0) {
                    return 0;
                }
            }
            else {
                return 0;
            }
            return 1;
        }
    }
}
