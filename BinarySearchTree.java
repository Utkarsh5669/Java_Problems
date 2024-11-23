class BinarySearchTree {
    // Node class for BST
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // Searching in BST
    Node search(Node root, int key) {
        // Base Cases: root is null or key is present at root
        if (root == null || root.data == key)
            return root;

        // Key is greater than root's key
        if (root.data < key)
            return search(root.right, key);

        // Key is smaller than root's key
        return search(root.left, key);
    }

    // Insertion in BST
    Node insert(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.data)
            root.left = insert(root.left, key);
        else if (key > root.data)
            root.right = insert(root.right, key);

        // Return the unchanged node pointer
        return root;
    }

    // Inorder traversal to print the tree
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Deletion in BST
    Node deleteNode(Node root, int key) {
        // Base Case
        if (root == null) return root;

        // Recur down the tree
        if (key < root.data)
            root.left = deleteNode(root.left, key);
        else if (key > root.data)
            root.right = deleteNode(root.right, key);
        
        // If key is same as root's key, then this is the node to be deleted
        else {
            // Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children: Get the inorder successor 
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteNode(root.right, root.data);
        }

        return root;
    }

    // Find minimum value in a tree
    int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    // Main method for demonstration
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Insertion
        tree.root = tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);

        // Inorder traversal
        System.out.println("Inorder traversal of the BST:");
        tree.inorder(tree.root);

        // Search
        System.out.println("\n\nSearching for 40:");
        Node searchResult = tree.search(tree.root, 40);
        System.out.println(searchResult != null ? "Found" : "Not Found");

        // Deletion
        System.out.println("\nDeleting 40");
        tree.root = tree.deleteNode(tree.root, 40);
        
        System.out.println("Inorder traversal after deletion:");
        tree.inorder(tree.root);
    }
}