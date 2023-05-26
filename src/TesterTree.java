public class TesterTree {
    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(4);
        tree.insert(2);
        tree.insert(6);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(7);

        System.out.println("Enesimo Elemento: " + tree.nElement(3));
        System.out.println("Posição do Elemento: " + tree.position(6));
        System.out.println("Mediana da Árvore: " + tree.median());
        System.out.printf("Media aritmética do nó: %.2f \n", tree.media(5));
        System.out.println("Árvore em pré-ordem: " + tree.preOrder());
        if (tree.isFull())
            System.out.println("A árvore binária é cheia");
        else
            System.out.println("A árvore binária não é cheia");

        if (tree.isComplete())
            System.out.println("A árvore binária é completa");
        else
            System.out.println("A árvore binária não é completa");

    }
}