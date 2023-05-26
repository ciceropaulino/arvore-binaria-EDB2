
public class BinarySearchTree {

    Node root;
    /*Metodo de usuario para inserir.*/
    public void insert(int value) {

        Node node = new Node(value);
        root = backInsert(root, node);
    }
    /*Metodo de insersao recursivo privado*/
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
    /*Metodo de usuario para buscar*/
    public boolean search(int value) {

        int data = value;

        return (backSearch(root, data))?
         true : false;
    }
    /*Metodo de busca recursivo privado*/
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
    /*Metodo de usuario para remover no da arvore*/
    public void remove(int data) {
        if (search(data)) {
            root = backRemove(root, data);
        } else {
            System.out.println(data + " Remove error, root not found.");
        }
    }
    /*Metodo de remorcao recursivo privado*/
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
    /*Metodo retorna o sucessor de uma determinada sub-raiz*/
    private int successor(Node root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }
    /*Metodo retorna o predecessor de uma determinada sub-raiz*/
    private int predecessor(Node root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    //#########################################################
    /*Metodo de usuario que recebe uma posicao inteira e retorna o numero correspondente a essa po-
    sicao
     */
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

    private int backPosition(Node root, int value, Counter count) {
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

    /*metodo de usuario que retorna a media dos elementos da arvore*/
    public double media (int x){
        if(search(x)) {
            Node temp = new Node(x);
            Counter count = new Counter();
            double soma = countElements(temp, count, 1);
            count.count *= 0;
            double numElements = countElements(temp, count, 0);
            return soma/numElements;
        } else {
            System.out.println("ERROR: root invalid.");
            return -1;
        }

    }
    /*Metodo de usuario que retorna a mediana dos elementos da arvore*/
    public int median(){
        Counter count = new Counter();
        double numElements = countElements(root, count, 0);
        
        return backMedian(root, numElements);
    }
    /*Metodo auxiliar recursivo que busca pela mediana*/
    private int backMedian(Node root, double numElements){
        int p = position(root.data);
        if(p == Math.ceil(numElements/2)){
            return root.data;
        }
        else{
            if(p < Math.ceil(numElements/2)){
                return backMedian(root.right, numElements);
            }
            else{
                return backMedian(root.left, numElements);
            }
        }
    }
    /*Metodo contador de elementos*/
    private double countElements(Node root, Counter count, int x){
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
    /*Metodo de usuario que retorna string dos elementos da arvore em pre-ordem*/
    public String preOrder(){
        StringBuilder sb = new StringBuilder();
        backPreOrder(root, sb);
        return sb.toString();
    }
    /*Metodo auxiliar recursivo que percorre a arvore em preordem */ 
    private void backPreOrder(Node root, StringBuilder sb){
        if(root != null){
            sb.append(root.data).append(" ");
            backPreOrder(root.left, sb);
            backPreOrder(root.right, sb);
        }
    }
    //###########################################################//
    //####################################
    public boolean isFull() {
        return backIsFull(root);
    }

    private boolean backIsFull(Node node) {
        if (node == null)
            return true;

        if (node.left == null && node.right == null)
            return true;

        if (node.left != null && node.right != null)
            return (backIsFull(node.left) && backIsFull(node.right));

        return false;
    }

    public boolean isComplete() {
        int index = 0;
        int count = countNodes(root);
        return backIsComplete(root, index, count);
    }
    
    private int countNodes(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
    
    private boolean backIsComplete(Node node, int index, int count) {
        if (node == null) {
            return true;
        }
        if (index >= count) {
            return false;
        }
        return backIsComplete(node.left, 2 * index + 1, count) &&
               backIsComplete(node.right, 2 * index + 2, count);
    }
    
}
