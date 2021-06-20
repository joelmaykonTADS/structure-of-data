public class PilhaRubroNegra implements IPilhaRubroNegra {

    private Object[] pilha;
    private int topoRubro = -1;
    private int topoNegro;
    int posicaoTopoNegro = 0;
    
    public PilhaRubroNegra(int tamanho) {
       pilha = new Object[tamanho];
        topoNegro = pilha.length;
    }

    public boolean isFull() {
        return topoNegro - topoRubro < 2;
    }

    public Object[] dupArray(Object[] pilha) { 
				int novoTamanho = pilha.length * 2;        
        Object[] novaPilha = new Object[novoTamanho];
        
        // copia Pilha Rubro
        for (int i = 0; i < topoRubro + 1; i++) {
            novaPilha[i] = pilha[i];
						System.out.print("rubro copiado: " + pilha[i] + "\n");
        }
        //copia a pilha negra
        for (int j = pilha.length - 1; j >= topoNegro; j--) {
					--novoTamanho;
          novaPilha[novoTamanho] = pilha[j];
					System.out.print("negro copiado: " + pilha[j]+ "\n");
        }				
				System.out.print("____________________NOVA PILHA PÓS DUPICAÇÃO___________________________ \n");
				for (int i = 0; i < novaPilha.length; i++) {
        System.out.print(novaPilha[i] + " | ");
        }					
				System.out.print("\n ________________________________________________ \n");
				// o posicaoTopoNegro  é  a posição do topoNegro no array antigo.
        topoNegro = novaPilha.length - posicaoTopoNegro;
        return novaPilha;
    }

    @Override
    public Object topoRubro() {
        return pilha[topoRubro];
    }

    @Override
    public Object topoNegro() {
        return pilha[topoRubro];
    }

    @Override
    public void pushRubro(Object o) {       
        if (isFull()) {
            pilha = dupArray(pilha);            
        }
        topoRubro++;
        pilha[topoRubro] = o;
				 System.out.println("Adicionado rubro: " + o);
    }

    @Override
    public void pushNegro(Object o) {
        if (isFull()) {
           pilha = dupArray(pilha);
        }
        posicaoTopoNegro++;
        topoNegro--;
        pilha[topoNegro] = o;
				 System.out.println("Adicionado negro: " + o);
    }

    @Override
    public Object popRubro() throws EVazia {
        if (isEmpty()) {
            throw new RuntimeException("Pilha vazia");
        } else if (isEmptyRubro()) {
            throw new RuntimeException("Pilha Rubro vazia");
        } else {
            Object objeto;
            objeto = pilha[topoRubro];
            topoRubro--;
            pilha[topoRubro + 1] = null;
						 System.out.println("Removido rubro: " + objeto);
            return objeto;
        }
    }

    public boolean isEmptyRubro() {
        return topoNegro == -1;
    }

    @Override
    public Object popNegro() throws EVazia {
        if (isEmpty()) {
            throw new RuntimeException("Pilha vazia");
            //throw new PilhaVazia("A Pilha está vazia");

        } else if (isEmptyRubro()) {
            throw new RuntimeException("Pilha Negra vazia");
            //throw new PilhaVazia("A Pilha Rubro está vazia");
        } else {
            Object objeto;
            objeto = pilha[topoNegro];
            topoNegro++;
            pilha[topoNegro - 1] = null;
            posicaoTopoNegro--;
						System.out.println("Removido negro: " + objeto);
            return objeto;
        }
    }

    @Override
    public boolean isEmpty() {
        return topoRubro == -1 && topoNegro == pilha.length;
    }
    
    @Override
    public int all() {
        for (int i = 0; i < pilha.length; i++) {
            System.out.print(pilha[i] + " | ");
        }
        System.out.println("");
        return 0;
    }

    @Override
    public int size() {
        return sizeRubro() + sizeNegro();
    }

    @Override
    public int sizeNegro() {
        return posicaoTopoNegro;
    }

    @Override
    public int sizeRubro() {
        return  topoRubro + 1;
    }

}