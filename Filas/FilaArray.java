public class FilaArray implements IFila{
    private Object [] Fila ;
    private int primeiro;
    private int ultimo ;
    private int total;

    public FilaArray(int tamanho) {        
        Fila = new Object[tamanho];
        primeiro = 0;
        ultimo = 0;
        total =0;
    }
     public Object[] duplicaFila(Object[] fila){
         Object[] filaNova  = new Object[fila.length * 2];
         for (int i = 0; i < fila.length; i++) {
            filaNova[i] = fila[(i + primeiro) % fila.length];
						 System.out.print(" item copiado: "+ filaNova[i] + "\n");
         }
				 System.out.print("____________________NOVA FILA PÓS DUPICAÇÃO___________________________ \n \n");
        for (int i = 0; i < filaNova.length; i++) {
            System.out.print(" | " + filaNova[i]);
        }
				System.out.print("\n_______________________________________________ \n");
        System.out.println("");
        return filaNova;
    }
    @Override
    public int tamanho() {
        int tamanho = (Fila.length - primeiro + ultimo) % Fila.length;
        return tamanho;
    }
    @Override
    public boolean estaVazia() {
        return primeiro == ultimo;
    }

    @Override
    public Object inicio() throws EVazia {
        return Fila[primeiro];
    }

    @Override
    public void enfileirar(Object o) {
        if(isFull()){
          Fila =  duplicaFila(Fila);
        }
        Fila[ultimo]= o;
        ultimo = (ultimo + 1)% Fila.length;
        total ++;
				System.out.println("adicionado: " + o);
    }
    public boolean isFull(){
       return  total == Fila.length;
    }
    @Override
    public Object desenfileirar() throws EVazia {
        Object o = Fila[primeiro];
        primeiro = (primeiro + 1) % Fila.length;
        Fila[primeiro - 1] = null;
        total--;
				System.out.println("Removido: " + o);
        return 0;
    }

    @Override
    public void mostrarFila() {
        for (int i = 0; i < Fila.length; i++) {
            System.out.print(" | " + Fila[i]);
        }
        System.out.println("");
    }
}