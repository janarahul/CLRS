class isSubtree {
    public static boolean isIdentical(Node node1, Node node2){
        if (node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }
        if (node1 != null && node2 != null && node1.data == node2.data){
            return isIdentical(node1.left,node2.left) && isIdentical(node1.right,node2.right); 
        }
        return false;
    }
    public static boolean isSubtree(Node T, Node S) {
        // add code here.
        if (S== null){
            return true;
        }
        if (T == null){
            return false;
        }
        
        if (isIdentical(T,S)){
            return true;
        }
        return isSubtree(T.left,S) || isSubtree(T.right,S);
    }
}
