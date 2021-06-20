public interface IPilhaArray {
    public int size();
    public boolean isEmpty();
    public Object top();
    public void push(Object o);
    public Object pop();
    public void status(String op, Object element);
    public void all();
}