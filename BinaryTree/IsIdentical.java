/* class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}*/

class IsIdentical
{
	boolean isIdentical(Node root1, Node root2)
	{
	    // Code Here
	    if(root1 == null && root2 == null){
	        return true;
	    }
	    if(root1 != null && root2 != null && root1.data == root2.data){
	        return isIdentical(root1.left,root2.left) && isIdentical(root1.right,root2.right);
	    }
	    return false;
	}
	
}
