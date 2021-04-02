class Node{
  Node left,right;
  int key;
  Node(int k){
    this.key = k;
  }
}
class BST{
  Node root;
  boolean isBSTUtil(Node node,int min, int max){
    if (node == null){
      return true;
    }
    if (node.key < min || node.key > max){
      return false;
    }
    return (isBSTUtil(node.left, min, node.key -1) && isBSTUtil(node.right, node.key +1,max));
  }
  boolean checkBST(){
    return isBSTUtil(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
}
class CheckBSTAlgo{
  public static void main(String[] args) {
    BST tree = new BST(); 
    tree.root = new Node(4); 
    tree.root.left = new Node(2); 
    tree.root.right = new Node(5); 
    tree.root.left.left = new Node(1); 
    // tree.root.left.right = new Node(6); 

    if (tree.checkBST()) 
        System.out.println("IS BST"); 
    else
        System.out.println("Not a BST");
  }
}
