public class gfg16march {
    class Solution
{void deleteNode(Node delnode)
    {
         if(delnode.next==null || delnode==null) 
            return;
         
         delnode.data=delnode.next.data;
         delnode.next=delnode.next.next;
         
    }
}
}
