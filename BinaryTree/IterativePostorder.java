class IterativePostorder{
	ArrayList<Integer> iterativePostorder(Node node){
	       ArrayList<Integer> out = new ArrayList<Integer>();
	       Stack<Node> s = new Stack<Node>();
	       if(node == null){
		       return out;
	       }
	       // Keep track of last visited node
	       Node pre = null;
	       while( node != null|| !s.empty()){
		    if(node != null){
	                s.push(node);
			node = node.left;
		    }else{
			node = s.peek();
			if(node.right == null || node.right == pre){
				out.add(node.data);
				s.pop();
				pre = node;
				node = null;
			}else{
				node = node.right;
			}
		    }
	       }
	       return out;
	}
}
