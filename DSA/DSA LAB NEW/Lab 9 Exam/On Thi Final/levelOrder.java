	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static void levelOrder(Node root) {
       if (root == null) {
            return; 
        }
        
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            
            System.out.print(currentNode.data + " ");
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }