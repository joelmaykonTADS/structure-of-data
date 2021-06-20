/**
 *
 * 
 * @author Daniel Brunno https://gitlab.com/danielbrunno1/estruturadedados
 */

public class No {
    private int key, height;
    private No left, right;

    public No() {
    }

    No(int key) {
        this.key = key;
    }

    public No getRight() {
        return right;
    }

    public void setRight(No right) {
        this.right = right;
    }

    public No getLeft() {
        return left;
    }

    public void setLeft(No left) {
        this.left = left;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "" + getKey();
    }

}