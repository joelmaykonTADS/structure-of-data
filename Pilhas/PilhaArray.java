public class PilhaArray implements IPilhaArray {

    private Object pilha[];
    private int topo = -1;
    public static int CAPACIDADE = 1000;

    public PilhaArray() {
        this(CAPACIDADE);
    }

    public PilhaArray(int tam) {
        CAPACIDADE = tam;
        pilha = new Object[CAPACIDADE];
    }

    @Override
    public int size() {
        return topo + 1;
    }

    @Override
    public boolean isEmpty() {
        return (topo < 0);
    }

    @Override
    public Object top() {
        if (isEmpty()) {
            return "Pilha vazia";
        } else {
            return pilha[topo];
        }
    }
    public void duplica(){
				int novaCapacidade = CAPACIDADE * 2;
        Object novaPilha[] = new Object[novaCapacidade];
        for (int i = 0; i < pilha.length; i++) {
            novaPilha[i] = pilha[i];
        }
        pilha = novaPilha;
        CAPACIDADE = novaCapacidade;
    }
    @Override
    public void push(Object o) {
      int t = pilha.length;
        if (size() == t) {
           Object novaPilha[] = new Object[t *2];
           for(int i = 0; i < t;i++){
              novaPilha[i]= pilha[i];
           } 
           pilha= novaPilha;
           System.out.println("Adicionado: " + o);
        }
        pilha[++topo] = o;
				System.out.println("Adicionado: " + o);
        
    }

    @Override
    public Object pop() {
       Object o;
        if(isEmpty()){
            return "Pilha vazia";
        }else{
           o = pilha[topo];
           pilha[topo--] = null;
					 System.out.println("Removido: " + o);
           return o;
        }
    }

    @Override
    public void status(String operacao, Object elemento) {
        System.out.println("------> " + operacao);
        System.out.println("retorna " + elemento);
        System.out.println("resultado: tamanho = "+size() + ", e vazio é" +isEmpty());
        all();

    }

    @Override
    public void all() {
      for (int i = 0; i < pilha.length; i++) {
            System.out.print(pilha[i] + " | ");
        }
        System.out.println("");  
    }  
}