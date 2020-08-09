import java.util.*;

class Node{
	int data;
	Node left,right;
	Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
class BinaryTree{
	public static void levelOrderTraversal(Node root){
		Queue<Node> queue = new LinkedList<Node>();
		if (root == null){
			return;
		}
		queue.add(root);
		while(!queue.isEmpty()){
			Node element = queue.remove();
			System.out.println(element.data);
			if (element.left != null){
				queue.add(element.left);
			}
			if (element.right != null){
				queue.add(element.right);
			}
		}
	}
	public static boolean isComplete(Node root){
		Queue<Node> queue = new LinkedList<Node>();
		if (root == null){
			return true;
		}
		queue.add(root);
		boolean flag = false;
		while(!queue.isEmpty()){
			Node element = queue.remove();
			if(element.left == null && element.right == null){
				flag = true;
			}
			else if(element.left != null && element.right != null){
				if(flag == true){
					return false;
				}
				queue.add(element.left);
				queue.add(element.right);
			}
			else if(element.right == null){
				if(flag == true){
					return false;
				}
				flag = true;
				queue.add(element.left);
			}else{
				return false;
			}
		}
		return true;
	}
	public static boolean isHeap(Node root){
		Queue<Node> queue = new LinkedList<Node>();
		if (root == null){
			return true;
		}
		queue.add(root);
		boolean flag = false;
		while(!queue.isEmpty()){
			Node element = queue.remove();
			if(element.left == null && element.right == null){
				flag = true;
			}
			else if(element.left != null && element.right != null){
				if(flag == true){
					return false;
				}
				int childMax = Math.max(element.left.data,element.right.data);
				if (element.data < childMax){
					return false;
				}
				queue.add(element.left);
				queue.add(element.right);
			}
			else if(element.right == null){
				if(flag == true){
					return false;
				}
				flag = true;
				if (element.data < element.left.data){
					return false;
				}
				queue.add(element.left);
			}else{
				return false;
			}
		}
		return true;
	}
}
class checkHeap{
	public static void main(String argsp[]){
		Node treeRoot = new Node(10); 
        treeRoot.left = new Node(9); 
        treeRoot.right = new Node(8); 
        treeRoot.left.left = new Node(7); 
        treeRoot.left.right = new Node(6); 
        treeRoot.right.left = new Node(5); 
        treeRoot.right.right = new Node(4); 
        treeRoot.left.left.left = new Node(3); 
        treeRoot.left.left.right = new Node(2); 
        treeRoot.left.right.left = new Node(1);
        treeRoot.left.right.right = new Node(1);
        // BinaryTree.levelOrderTraversal(treeRoot);
        System.out.println(BinaryTree.isHeap(treeRoot)); 
	}

}