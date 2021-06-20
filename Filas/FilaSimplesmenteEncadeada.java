public class FilaSimplesmenteEncadeada {

    private No inicio, fim;

    public FilaSimplesmenteEncadeada() {
        inicio = null;
        fim = null;
    }

    public void enfileirar(Object elemento) {
        No n = new No();
        n.setElemento(elemento);  // insere novo nó.
        n.setProximo(null);      // depois do novo nó não há outro nó.
        if (inicio == null) {
            inicio = n;
            fim = n;
						System.out.println("adicionado: " + elemento);
        } else {
            fim.setProximo(n);
            System.out.println("adicionado: " + elemento);
            fim = n;
        }
    }

    public Object desenfileirar() {
        if (isEmpty()) {
            throw new RuntimeException(" Fila Vazia");
        }
        No aux = inicio;
        Object o = aux.getElemento();
        inicio = aux.getProximo();
        System.out.println("removido: " + o);
        return o;

    }

    public void mostrar() {
        if (inicio == null) {
            System.out.println("Fila Vazia");
        } else {
            No aux = inicio;
            while (aux != null) {

                System.out.print(aux.getElemento() + " | ");
                aux = aux.getProximo();
            }
            System.out.println("");
        }
    }

    public boolean isEmpty() {
        return this.inicio == null;
    }

}