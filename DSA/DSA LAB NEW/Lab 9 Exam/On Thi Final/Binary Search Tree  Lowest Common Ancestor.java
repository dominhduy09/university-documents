	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static Node lca(Node root, int v1, int v2) {
        // Write your code here.
      if (root == null || root.data == v1 || root.data == v2) {
          return root;
      }
      
      Node left_value = lca(root.left,v1,v2);
      Node right_value = lca(root.right,v1,v2);
      
      if (left_value == null) {
          return right_value;
      } 
      else if (right_value == null) {
          return left_value;
      } 
      else {
          return root;
      }
  }