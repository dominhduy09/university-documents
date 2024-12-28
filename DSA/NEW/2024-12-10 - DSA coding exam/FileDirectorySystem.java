public class FileDirectorySystem {
    
    // Node class representing each file in the directory
    class Node {
        int fileSize;
        String fileName;
        Node left, right;

        public Node(int fileSize, String fileName) {
            this.fileSize = fileSize;
            this.fileName = fileName;
            this.left = this.right = null;
        }
    }

    private Node root;

    public FileDirectorySystem() {
        this.root = null;
    }

    // 1. Insert a file
    public void insert(int fileSize, String fileName) {
        root = insertRec(root, fileSize, fileName);
    }

    private Node insertRec(Node root, int fileSize, String fileName) {
        if (root == null) {
            root = new Node(fileSize, fileName);
            return root;
        }

        if (fileSize < root.fileSize) {
            root.left = insertRec(root.left, fileSize, fileName);
        } else if (fileSize > root.fileSize) {
            root.right = insertRec(root.right, fileSize, fileName);
        }

        return root;
    }

    // 2. Delete a file
    public void delete(int fileSize) {
        root = deleteRec(root, fileSize);
    }

    private Node deleteRec(Node root, int fileSize) {
        if (root == null) {
            return root;
        }

        if (fileSize < root.fileSize) {
            root.left = deleteRec(root.left, fileSize);
        } else if (fileSize > root.fileSize) {
            root.right = deleteRec(root.right, fileSize);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            Node successor = minValueNode(root.right);

            root.fileSize = successor.fileSize;
            root.fileName = successor.fileName;

            root.right = deleteRec(root.right, successor.fileSize);
        }

        return root;
    }

    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // 3. Find the smallest file
    public void findSmallestFile() {
        if (root == null) {
            System.out.println("The directory is empty.");
        } else {
            Node smallest = minValueNode(root);
            System.out.println("Smallest file: Name = " + smallest.fileName + ", Size = " + smallest.fileSize);
        }
    }

    // 4. Find the largest file
    public void findLargestFile() {
        if (root == null) {
            System.out.println("The directory is empty.");
        } else {
            Node largest = maxValueNode(root);
            System.out.println("Largest file: Name = " + largest.fileName + ", Size = " + largest.fileSize);
        }
    }

    private Node maxValueNode(Node node) {
        Node current = node;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    // 5. In-order traversal
    public void inOrderTraversal() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print("(Name: " + root.fileName + ", Size: " + root.fileSize + ") ");
            inOrderRec(root.right);
        }
    }

    // Main method to demonstrate the operations
    public static void main(String[] args) {
        FileDirectorySystem fds = new FileDirectorySystem();

        // Insert files
        fds.insert(50, "FileA.txt");
        fds.insert(30, "FileB.txt");
        fds.insert(20, "FileC.txt");
        fds.insert(40, "FileD.txt");
        fds.insert(70, "FileE.txt");
        fds.insert(60, "FileF.txt");
        fds.insert(80, "FileG.txt");

        System.out.println("In-order traversal of the file directory:");
        fds.inOrderTraversal();

        fds.findSmallestFile();
        fds.findLargestFile();

        System.out.println("\nDeleting file with size 20");
        fds.delete(20);
        System.out.println("In-order traversal of the file directory after deletion:");
        fds.inOrderTraversal();

        System.out.println("\nDeleting file with size 50");
        fds.delete(50);
        System.out.println("In-order traversal of the file directory after deletion:");
        fds.inOrderTraversal();
    }
}
