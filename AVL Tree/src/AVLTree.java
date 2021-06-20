
import java.util.ArrayList;

public class AVLTree {
    private No root;
    private ArrayList<No> list = new ArrayList<No>();

    public void fill(No leaf) {
        if (leaf != null) {
            fill(leaf.getLeft());
            list.add(leaf);
            fill(leaf.getRight());
        }
    }

    public int countNode(No atual) {
        if (atual == null)
            return 0;
        else
            return (1 + countNode(atual.getLeft()) + countNode(atual.getRight()));
    }

    public int depth(No node) {
        int depth;
        if (node == getRoot())
            depth = 0;
        else {
            depth = getRoot().getHeight() - node.getHeight();
        }
        return depth;
    }

    public void print() {
        int tam = countNode(getRoot()) + 1;
        list = new ArrayList<No>();
        fill(getRoot());
        int matriz[][] = new int[tam][tam - 1];
        for (int i = 0; i < list.size(); i++) {
            matriz[depth(list.get(i))][i] = list.get(i).getKey();
            System.out.print(" " + depth(list.get(i)));
        }
        System.out.println("\n");
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam - 1; j++) {
                if (matriz[i][j] != 0) {
                    System.out.print(
                            "[" + list.get(i).getHeight() + "]" + matriz[i][j] + "[" + depth(list.get(i)) + "]" + "\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    public No find(int key) {
        No temp = root;
        while (temp != null) {
            if (temp.getKey() == key) {
                break;
            }
            temp = temp.getKey() < key ? temp.getRight() : temp.getLeft();
        }
        return temp;
    }

    void updateHeight(No node) {
        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
    }

    int height(No node) {
        return node == null ? -1 : node.getHeight();
    }

    int getBalance(No node) {
        return (node == null) ? 0 : height(node.getRight()) - height(node.getLeft());
    }

    No rotateRight(No node) {
        No left = node.getLeft();
        No right = left.getRight();
        left.setRight(node);
        node.setLeft(right);
        updateHeight(node);
        updateHeight(left);
        return left;
    }

    No rotateLeft(No node) {
        No left = node.getRight();
        No right = left.getLeft();
        left.setLeft(node);
        node.setRight(right);
        updateHeight(node);
        updateHeight(left);
        return left;
    }

    No balance(No node) {
        updateHeight(node);
        int balance = getBalance(node);
        if (balance > 1) {
            if (height(node.getRight().getRight()) > height(node.getRight().getLeft())) {
                node = rotateLeft(node);
            } else {
                node.setRight(rotateRight(node.getRight()));
                node = rotateLeft(node);
            }
        } else if (balance < -1) {
            if (height(node.getLeft().getLeft()) > height(node.getLeft().getRight()))
                node = rotateRight(node);
            else {
                node.setLeft(rotateLeft(node.getLeft()));
                node = rotateRight(node);
            }
        }
        return node;
    }

    public void insertNo(int key) {
        root = insert(root, key);
    }

    public void deleteNo(int key) {
        root = delete(root, key);
    }

    public No getRoot() {
        return root;
    }

    No insert(No node, int key) {
        if (node == null) {
            return new No(key);
        } else if (node.getKey() > key) {
            node.setLeft(insert(node.getLeft(), key));
        } else if (node.getKey() < key) {
            node.setRight(insert(node.getRight(), key));
        } else {
            throw new RuntimeException("duplicate Key!");
        }
        return balance(node);
    }

    No delete(No node, int key) {
        if (node == null) {
            return node;
        } else if (node.getKey() > key) {
            node.setLeft(delete(node.getLeft(), key));
        } else if (node.getKey() < key) {
            node.setRight(delete(node.getRight(), key));
        } else {
            if (node.getLeft() == null || node.getRight() == null) {
                node = (node.getLeft() == null) ? node.getRight() : node.getLeft();
            } else {
                No mostLeftChild = mostLeft(node.getRight());
                node.setKey(mostLeftChild.getKey());
                node.setRight(delete(node.getRight(), node.getKey()));
            }
        }
        if (node != null) {
            node = balance(node);
        }
        return node;
    }

    private No mostLeft(No node) {
        No temp = node;
        while (temp.getLeft() != null) {
            temp = temp.getLeft();
        }
        return temp;
    }

}