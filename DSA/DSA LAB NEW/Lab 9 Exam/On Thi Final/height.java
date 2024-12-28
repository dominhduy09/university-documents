/*
class Node 
	int data;
	Node left;
	Node right;
*/
public static int height(Node root) {
    // Write your code here.
    if (root == null) {
        return -1;
    }

    else {
        int lheight = height(root.left);
        int rheight = height(root.right);

        if (lheight > rheight) {
            return lheight + 1;
        } else {
            return rheight + 1;
        }
    }

}