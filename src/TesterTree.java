public class TesterTree {
    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(3);
        tree.insert(5);
        tree.insert(6);
        tree.insert(8);
        tree.insert(9);

        //tree.remove(2);
        //tree.remove(90 );
        tree.display();

        System.out.println(tree.search(5));

        //int position = tree.nElement(5);

        //System.out.println("N element: " + position);

        System.out.println("Enesimo Elemento: " + tree.nElement(3));
        System.out.println("Posição do Elemento: " + tree.position(50));
        System.out.println("Mediana da Árvore: " + tree.mediana());
        System.out.printf("Media aritmética do nó: %.2f \n", tree.media(5));
        System.out.println("Árvore em pré-ordem: " + tree.pre_ordem());

    }
}