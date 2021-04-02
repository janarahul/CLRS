class SpiralTraversal {
  public static ArrayList<Integer> spiralTraversal(Node root){
    LinkedList<Node> currentLevel = new LinkedList<Node>();
    LinkedList<Node> nextLevel = new LinkedList<Node>();
    ArrayList<Integer> output = new ArrayList<Integer>();
    if(root == null){
      return output;
    }
    currentLevel.addLast(root);
    boolean isLeftToRight = true;
    while(!currentLevel.isEmpty()){
      Node t = currentLevel.removeLast();
      output.add(t.data);
      if(isLeftToRight){
        if(t.left != null){
          nextLevel.addLast(t.left);
        }
        if(t.right != null){
          nextLevel.addLast(t.right);
        }
      }else{
        if(t.right != null){
          nextLevel.addLast(t.right);
        }
        if(t.left != null){
          nextLevel.addLast(t.left);
        }
      }
      if(currentLevel.isEmpty()){
        isLeftToRight = !isLeftToRight;
        LinkedList<Node> temp = currentLevel;
        currentLevel = nextLevel;
        nextLevel = temp;
      }
    }
    return output;
  }
  public static void main(String args[]){

  }
}