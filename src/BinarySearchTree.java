
public class BinarySearchTree {

    Node root;

    public void insert(int value) { //front method to insert
        if (search(value)) {
            System.out.println("INVALID ACTION: node already exist.\n"
            + "    " + value + "\n    ^\n");
        } else {
            Node node = new Node(value);
            root = back_insert(root, node);
        }
    }

    private Node back_insert(Node root, Node node) { //back method to insert

        int data = node.data;

        if(root == null) { 
            root = node;
            return root;
        } else if(data < root.data) {
            root.left= back_insert(root.left, node);
        }else {
            root.right = back_insert(root.right, node);
        }
        return root;
    }

    public void display() {
        displayHelper(root);
    }
    private void displayHelper(Node root) {

        if(root != null) {
            displayHelper(root.left);
            System.out.println(root.data);
            displayHelper(root.right);
        }

    }

    public boolean search(int value) {

        int data = value;

        return (back_search(root, data))?
         true : false;
    } //front method 
    //to search

    public boolean back_search(Node root, int data) {
        if(root == null) {
            return false;
        } else if(root.data == data) {
            return true;
        } else if(root.data > data) {
            return back_search(root.left, data);
        } else {
            return back_search(root.right, data);
        }
    }
/* 
    public void remove(int data) {

        if(search(data)) {
            removeHelper(root, data);
        } else {
            System.out.println(data + " Remove error, root not be found.");;
        }
    }
    private Node removeHelper(Node root, int data) {
        if(root == null) {
            return root;
        } else if(data < root.data) {
            root.left = removeHelper(root.left, data);
        } else if(data > root.data) {
            root.right = removeHelper(root.right, data);
        } else { //node found
            if(root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) { // encontra o sucessor para substituir este node
                root.data = sucessor(root);
                root.right = removeHelper(root.right, data);
            } else { //encontra o predecessor para subistituir esse nó
                root.data = predecessor(root);
                root.left = removeHelper(root.left, data);
            }
        }

        return root;
    }
    private int sucessor(Node root) { //encontra algum valor menor que o filho da direita

        root = root.right;

        while(root.left != null) {
            root = root.left;
        }
        return root.data;
    }
    private int predecessor(Node root) {

        root = root.left;

        while(root.right != null) {
            root = root.right;
        }
        return root.data;
    }
    */
}
