class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}
class Pre_Post_In_Order {
    Node root;
    void preorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }
    void inorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }
    void postorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.data + " ");
    }
    public static void main(String[] args) {
        Pre_Post_In_Order tree = new Pre_Post_In_Order();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Preorder traversal:");
        tree.preorderTraversal(tree.root); 

        System.out.println("\nInorder traversal:");
        tree.inorderTraversal(tree.root); 

        System.out.println("\nPostorder traversal:");
        tree.postorderTraversal(tree.root); 
    }
}
