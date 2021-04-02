class Diameter{ 
    void changeGlobal(int height,int diff){
        if((height + diff) > (g_height + g_diff)){
            g_height = height;
            g_diff = diff;
        }
    }
    int g_dia = Integer.MIN_VALUE;
    void changeDia(int val){
        if (val > g_dia){
            g_dia = val;
        }
    }
    int g_diff = Integer.MIN_VALUE;
    int g_height = Integer.MAX_VALUE;
    int myMethod(Node node){
        int height;
        if(node == null){
            height = 0;
            // diff = 0;
            changeDia(0);
            return height;
        }
        int lh = myMethod(node.left);
        int rh = myMethod(node.right);
        height = ((lh > rh)? lh : rh ) + 1;
        // diff = Math.abs(lh - rh);
        changeDia(lh+rh+1);
        return height;
    }
    
    /* Complete the function to get diameter of a binary tree */
    int diameter(Node root) {
        // Your code here
        myMethod(root);
        return (g_dia);
    }
}
