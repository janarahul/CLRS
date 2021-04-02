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
class LowestCommonAncestor
{
    
    Node lowestCommonAncestor;
    boolean postorderTraversal(Node node,int v1,int v2){
        if(node == null)
            return false;
        boolean leftCheck = postorderTraversal(node.left,v1,v2);
        boolean rightCheck = postorderTraversal(node.right,v1,v2);
        boolean myCheck = false;
        if(node.data  == v1 || node.data  == v2){
            myCheck = true;
        }
        if((leftCheck && rightCheck) || (leftCheck && myCheck) || (myCheck && rightCheck)){
            lowestCommonAncestor = node;
        }
        return (leftCheck || rightCheck || myCheck);
    }
    //Function to return the lowest common ancestor in a Binary Tree.
	Node lca(Node root, int n1,int n2)
	{
		// Your code here
	    postorderTraversal(root,n1,n2);
	    return lowestCommonAncestor;
	}
}
