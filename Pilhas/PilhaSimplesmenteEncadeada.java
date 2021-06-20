public class PilhaSimplesmenteEncadeada {
    private No topo;
    public PilhaSimplesmenteEncadeada(){
        topo = null;
    }
    public void empilhar(Object elemento){
        No no = new No();
        no.setElemento(elemento);
        no.setProximo(topo);
        topo = no;
				System.out.println("empilhado: " + elemento);
    }
    public Object desempilhar(){
        if(isEmpty()){
           throw new RuntimeException("Vazia");
        }
        Object o = topo.getElemento();
        topo = topo.getProximo();
				System.out.println("Removido: " + o);
        return o;
    }

    private boolean isEmpty() {
       return topo == null;
    }
    public void mostrar(){
        if(isEmpty()){
            System.out.println("Pilha vazia");
        }else{
            No aux = topo;
            while(aux != null ){
                System.out.println(" | " +  aux.getElemento());
                aux = aux.getProximo();
            }
        }
    }
}