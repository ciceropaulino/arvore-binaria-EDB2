
public class BinarySearchTree {

    Node root;

    public void insert(int value) { //front method to insert

        Node node = new Node(value);
        root = backInsert(root, node);
    }

    private Node backInsert(Node root, Node node) {

        if (root == null) {
            return node;
        } 
        if (node.data < root.data) {
            root.left = backInsert(root.left, node);

        } else if (node.data > root.data){
            root.right = backInsert(root.right, node);

        }

        return root;
    }


    public void display() {
        displayHelper(root);
    }
    private void displayHelper(Node root) {

        if(root != null) {
            displayHelper(root.left);
            System.out.println("\nValor: " + root.data);
            displayHelper(root.right);

        }
    }

    public boolean search(int value) { //Front method to search

        int data = value;

        return (backSearch(root, data))?
         true : false;
    }

    public boolean backSearch(Node root, int data) {
        if(root == null) {
            return false;
        } else if(root.data == data) {
            return true;
        } else if(root.data > data) {
            return backSearch(root.left, data);
        } else {
            return backSearch(root.right, data);
        }
    }

    public void remove(int data) {
        if (search(data)) {
            root = backRemove(root, data);
        } else {
            System.out.println(data + " Remove error, root not found.");
        }
    }
    
    private Node backRemove(Node root, int data) {
        if (root == null) {
            return null;
        } else if (data < root.data) {
            root.left = backRemove(root.left, data);
        } else if (data > root.data) {
            root.right = backRemove(root.right, data);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                int successorValue = successor(root);
                root.right = backRemove(root.right, successorValue);
                root.data = successorValue;
            } else {
                int predecessorValue = predecessor(root);
                root.left = backRemove(root.left, predecessorValue);
                root.data = predecessorValue;
            }
        }
    
        return root;
    }
    
    private int successor(Node root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }
    
    private int predecessor(Node root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }
}
