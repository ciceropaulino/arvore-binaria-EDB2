
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

    private boolean backSearch(Node root, int data) {
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

    //#########################################################

    public int nElement(int value) {
        Counter count = new Counter();
        Node element = searchSymmetricOrder(root, value, count);

        if(element != null) {
            return element.data;
        } else {
            System.out.println("ERROR. Element not found.");
        }

        return -1;
    }

    public Node searchSymmetricOrder(Node root, int data, Counter count) {
        if(root == null) {return null;}

        Node result = searchSymmetricOrder(root.left, data, count);
        if( result != null){
            return result;
        }
        count.count++;
        if(count.count == data){
            return root;
        }
        return searchSymmetricOrder(root.right, data, count);
    }

    public int position(int value) {
        Counter count = new Counter();
        int s = backPosition(root, value, count);
        if(s == -1){
            System.out.println("Elemento não encontrado!");
        }
        return s;
    }

    public int backPosition(Node root, int value, Counter count) {
        if (root != null) {
            int posicaoEsquerda = backPosition(root.left, value, count);
            if (posicaoEsquerda != -1) {
                return posicaoEsquerda;
            }

            count.count++;
            if (root.data == value) {
                return count.count;
            }

            return backPosition(root.right, value, count);
        }
        return -1; 
    }

    public Node searchForMedia(Node root, int key) { /// seria melhor que fosse so um boleano para ver se existe e rodar.
        if (root == null || root.data == key){
            return root;
        }

        if (key < root.data){
            return searchForMedia(root.left, key);
        }

        return searchForMedia(root.right, key);
    }

    public double media (int x){
        Node temp = searchForMedia(root, x);
        Counter count = new Counter();
        double soma = countElements(temp, count, 1);
        count.count *= 0;
        double numElements = countElements(temp, count, 0);
        return soma/numElements;
    }
    
    public int mediana(){
        Counter count = new Counter();
        double numElements = countElements(root, count, 0);
        
        return medianaRec(root, numElements);
    }
    
    public int medianaRec(Node root, double numElements){
        int p = position(root.data);
        if(p == Math.ceil(numElements/2)){
            return root.data;
        }
        else{
            if(p < Math.ceil(numElements/2)){
                return medianaRec(root.right, numElements);
            }
            else{
                return medianaRec(root.left, numElements);
            }
        }
    }
    
    public double countElements(Node root, Counter count, int x){
        if(root != null){
            if(x == 1){
                count.count+= root.data;
            }
            else{
                count.count++;
            }
            double left = countElements(root.left, count, x);
            if(left != count.count){
                return left;
            }
            
            return countElements(root.right, count, x);
        }
        
        return (double)count.count;
    }
    
    public String pre_ordem(){
        StringBuilder sb = new StringBuilder();
        preOrdemRec(root, sb);
        return sb.toString();
    }
    
    public void preOrdemRec(Node root, StringBuilder sb){
        if(root != null){
            sb.append(root.data).append(" ");
            preOrdemRec(root.left, sb);
            preOrdemRec(root.right, sb);
        }
    }
}
