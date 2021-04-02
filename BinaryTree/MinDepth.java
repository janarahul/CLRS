class MinDepth
{
	int minDepth(Node root)
	{
	    //code here
	    if(root == null){
	       return 0; 
	    }
	    int ld = minDepth(root.left);
	    int rd = minDepth(root.right);
	    if(root.left == null || root.right == null){
	        return( (ld > rd)? ld : rd) + 1;
	    }
	    return ((ld < rd)? ld : rd) + 1;
	}
}
