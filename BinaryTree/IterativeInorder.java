class IterativeInorder
{
    // Return a list containing the inorder traversal of the given tree
    ArrayList<Integer> inOrder(Node root)
    {
        // Code
        Stack<Node> s = new Stack<Node>();
        ArrayList<Integer> output = new ArrayList<Integer>();
        
        Node curr = root;
        while(curr != null || !s.empty()){
            while(curr != null){
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            output.add(curr.data);
            curr = curr.right;
        }
        return output;
    }
}
