
public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("\n Arvore AVL: ");
        AVLTree arvore = new AVLTree();
        /*
         * for (int i = 0; i < 8; i++) { arvore.insertNo(i); }
         */
        arvore.insertNo(3);
        arvore.insertNo(2);
        arvore.insertNo(1);
        arvore.insertNo(4);
        arvore.insertNo(5);      
        arvore.print();
        arvore.insertNo(8);
        arvore.deleteNo(2);
        arvore.print();
    }
}
