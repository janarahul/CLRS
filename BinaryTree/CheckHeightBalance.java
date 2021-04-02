import java.util.*;

class CheckHeightBalance {

  // Method to get height
  int height(Node node) {
      if(node ==null)
      return 0;
      
      int lh = height(node.left);
      int rh = height(node.right);
      
      return ((lh > rh) ? lh : rh) + 1;
  }
  boolean checkBalance(Node node,Height h){
    if(node == null){
        h.height = 0;
        return true;
    }
    Height lh = new Height();
    Height rh = new Height();
    boolean lb = checkBalance(node.left,lh);
    boolean rb = checkBalance(node.right,rh);
    h.height = ((lh.height > rh.height)? lh.height : rh.height ) + 1;
    
    if( Math.abs(lh.height - rh.height) >= 2){
        return false;
    }
    return lb && rb;
  }
  boolean isBalanced(Node root)
  {
    Height h = new Height();
    return checkBalance(root,h);
  }
  public static void main(String args[]){

  }
}