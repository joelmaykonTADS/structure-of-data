public interface IPilhaRubroNegra {

    public Object topoRubro();

    public Object topoNegro();

    public void pushRubro(Object o);

    public void pushNegro(Object o);

    public Object popRubro() throws EVazia;

    public Object popNegro() throws EVazia;

    public boolean isEmpty();

    public int all();

    public int size();

    public int sizeNegro();

    public int sizeRubro();
}