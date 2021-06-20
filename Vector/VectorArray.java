public class VectorArray {
	private Object[] array;
	private int tam;
	private int quantidade = 0;

	public VectorArray(int tamanho) {
		tam = tamanho;
		array = new Object[tam];
	}

	public Object elemAtRank(int posicao) {
		return array[posicao];
	}

	public int quantidadeInserida() {
		return quantidade;
	}

	public boolean vazio() {
		return quantidadeInserida() == 0;
	}

	public void insertAtRank(int posicao, Object e) {

		if (quantidade == tam) {
			tam *= 2;
			Object[] novoArray = new Object[tam];
			for (int i = 0; i < quantidade; i++) {
				novoArray[i] = array[i];
			}
			array = novoArray;
		} else {
			/* ele percorre do final até a posição que quero inserir movendo os elementos */
			for (int i = quantidade - 1; i >= posicao; i--) {
				array[i + 1] = array[i];
			}
			array[posicao] = e;
			quantidade++;
		}
	}

	public Object removeAtRank(int posicao) {
		if (!(posicao >= 0 && posicao < tam)) {
			System.out.println("Posição não existe");
		}
		Object temp = array[posicao];
		for (int i = posicao; i < tam - 1; i++){
			// removendo e realocando os elementos voltando 1.
			array[i] = array[i + 1];			
		}					
		quantidade--;
		return temp;
	}

	public Object replaceAtRank(int posicao, Object e) {
		Object temp = array[posicao];
		array[posicao] = e;
		return temp;
	}

	public void mostrarVector() {
		for (int i = 0; i < tam; i++) {
			System.out.println("Posição " + i + " : " + "Elemento " + elemAtRank(i));
		}
	}
}
