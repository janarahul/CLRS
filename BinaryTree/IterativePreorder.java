class IterativePreorder
{
    // Return a list containing the inorder traversal of the given tree
    ArrayList<Integer> preOrder(Node root)
    {
        // Code
        Stack<Node> s = new Stack<Node>();
        ArrayList<Integer> output = new ArrayList<Integer>();
        
        Node curr = root;
        while(curr != null || !s.empty()){
            while(curr != null){
                output.add(curr.data);
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            
            curr = curr.right;
        }
        return output;
    }
    
    
}
