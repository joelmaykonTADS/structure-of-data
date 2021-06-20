public interface IFila {

    public int tamanho();

    public boolean estaVazia();

    public Object inicio() throws EVazia;

    public void enfileirar(Object o);

    public Object desenfileirar() throws EVazia;

    public void mostrarFila();
}
