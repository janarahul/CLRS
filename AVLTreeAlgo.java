class Node{
  Node left,right;
  int height;
  int key;

  Node(int k){
    this.key = k;
    this.height = 1;
  }
}
class AVLTree{
  Node root;

  void preOrderTraversal(Node root){
    if(root == null){
      return;
    }
    System.out.println(root.key);
    preOrderTraversal(root.left);
    preOrderTraversal(root.right);
  }
  int max(int x,int y){
    return (x > y)? x : y; 
  }
  int height(Node node){
    if (node == null){
      return 0;
    }
    return node.height;
  }
  Node leftRotate(Node x){
    Node y = x.right;
    Node t2 = y.left;
    y.left = x;
    x.right = t2;
    y.height = max(height(y.left),height(y.right))+1;
    x.height = max(height(x.left),height(x.right))+1;
    return y;
  }
  Node rightRotate(Node y){
    Node x = y.left;
    Node t2 = x.right;
    x.right = y;
    y.left = t2;
    x.height = (max(height(x.left),height(x.right)))+1;
    y.height = (max(height(y.left),height(y.right)))+1;
    return x;
  }
  int getBalance(Node N) { 
    if (N == null) 
        return 0; 

    return height(N.left) - height(N.right); 
  } 
  Node insertAVL(Node root,Node node){
    if (root == null){
      return node;
    }
    if(node.key < root.key){
      root.left = insertAVL(root.left,node);
    }else if(node.key > root.key){
      root.right = insertAVL(root.right,node);
    }else{
      return root;
    }
    root.height = max(height(root.left),height(root.right)) +1;

    int balance = getBalance(root);
    if(balance > 1 && node.key < root.left.key ){
      return rightRotate(root);
    }else if(balance > 1 && node.key > root.left.key ){
      root.left = leftRotate(root.left);
      return rightRotate(root);
    }else if(balance < -1 && node.key > root.right.key ){
      return leftRotate(root);
    }else if(balance < -1 && node.key < root.right.key ){
      root.right = rightRotate(root.right);
      return leftRotate(root);
    }
    return root;
  }
  Node deleteAVL(Node root,int key){
    if (root == null){
      return root;
    }
    if(key < root.key){
      root.left = deleteAVL(root.left,key);
    }else if(key > root.key){
      root.right = deleteAVL(root.right,key);
    }else{

      if (root.left == null || root.right == null){
        Node temp = null;
        if root.left == null {
          temp = root.right;
        }else if (root.right == null){
          temp =root.left;
        }
        root = temp;
      }else{
        Node succ = minValue(root.right)
        root.key = succ.key
        root= deleteAVL(root.right,succ.key)
      }
    }
    root.height = max(height(root.left),height(root.right)) +1;

    int balance = getBalance(root);
    if(balance > 1 && getBalance(root.left) >= 0 ){
      return rightRotate(root);
    }else if(balance > 1 && getBalance(root.left) < 0 ){
      root.left = leftRotate(root.left);
      return rightRotate(root);
    }else if(balance < -1 && getBalance(root.right) <=0 ){
      return leftRotate(root);
    }else if(balance < -1 && getBalance(root.left) > 0 ){
      root.right = rightRotate(root.right);
      return leftRotate(root);
    }
    return root;
  }
}
class AVLTreeAlgo {
  public static void main(String args[]){
    AVLTree tree = new AVLTree();
    tree.root = tree.insertAVL(tree.root, new Node(20)); 
    tree.root = tree.insertAVL(tree.root, new Node(10)); 
    tree.root = tree.insertAVL(tree.root, new Node(40)); 
    tree.root = tree.insertAVL(tree.root, new Node(23)); 
    tree.root = tree.insertAVL(tree.root, new Node(70)); 
    tree.root = tree.insertAVL(tree.root, new Node(2));
    tree.preOrderTraversal(tree.root);
  }
}

