class BuildTree
{
    static int preOrderIndex;
    static HashMap<Integer,Integer> inOrderIndexMap;
    public static Node build(int inorder[], int preorder[], int left, int right){
        if(left > right){
            return null;
        }
        int rootValue = preorder[preOrderIndex];
        preOrderIndex++;
        Node root = new Node(rootValue);
        root.left = build(inorder,preorder,left,inOrderIndexMap.get(rootValue)-1);
        root.right = build(inorder,preorder,inOrderIndexMap.get(rootValue)+1,right);
        return root;
    }
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        preOrderIndex = 0;
        inOrderIndexMap = new HashMap<Integer,Integer>();
        for(int i=0;i< inorder.length;i++){
            inOrderIndexMap.put(inorder[i],i);
        }
        
        return build(inorder,preorder,0,n-1);
        
    }
}
