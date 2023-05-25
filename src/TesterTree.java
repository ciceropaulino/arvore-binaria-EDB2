public class TesterTree {
    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(5);
        tree.insert(1);
        tree.insert(7);
        tree.insert(2);
        tree.insert(3);
        tree.insert(8);
        tree.insert(6);
        tree.insert(9);
        tree.insert(4);
        tree.insert(9);
        tree.insert(9);
        tree.insert(9);
        tree.insert(9);

        tree.remove(2);
        tree.remove(90 );
        tree.display();

        System.out.println(tree.search(5));


    }
}