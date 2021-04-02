class Symetric {
  public static boolean isSymmetric(Node node1, Node node2){
    if (node1 == null && node1 == null){
      return true;
    }
    if(node1 != null && node2 != null && node1.key == node2.key){
      return (isSymmetric(node1.left,node2.right) && isSymmetric(node2.left,node1.right))
    }
    return false;
  }
  public static void main(String args[]){

  }
}