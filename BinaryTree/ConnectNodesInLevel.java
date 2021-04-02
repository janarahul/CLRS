import java.util.*;

    
    class Node{
        int data;
        Node left;
        Node right;
        Node nextRight;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
            nextRight = null;
        }
    }
class ConnectNodesInLevel
{
    HashMap<Integer,Node> aux;
    public void connector(Node node,int height,HashMap<Integer,Node> aux){
        if(node ==null){
            return;
        }
        // System.out.println("test1: "+height+" - "+ node.data+" - "+aux.containsKey(height));
        // System.out.println("test2: "+height);
        if(aux.containsKey(height)){
            Node pre = aux.remove(height);
            pre.nextRight = node;
        }
        aux.put(height,node);
    }
    public void inorderTraversal(Node node,int h,HashMap<Integer,Node> aux){
        if(node == null){
            return;
        }
        // System.out.println("test1: "+h+" - "+ node.data);
        inorderTraversal(node.left,h+1,aux);
        connector(node,h,aux);
        inorderTraversal(node.right,h+1,aux);
    }
    public void connect(Node root)
    {
        HashMap<Integer,Node> aux = new HashMap<Integer,Node>();
        // Your code goes here.
        inorderTraversal(root,0,aux);
    }
}
