public class Sequencia extends Lista {
	public NoDupla atRank(int rank) {
		NoDupla no;
		if (rank <= size() / 2) {
			no = first();
			for (int i = 0; i < rank; i++)
				no = no.getProximo();
		} else {
			no = last();
			for (int i = 1; i < size() - rank; i++)
				no = no.getAnterior();
		}
		return no;
	}

	public Object elemAtRank(int rank) {
		Object o = null;
		o = atRank(rank).getElemento();
		return o;
	}

	public int rankOf(NoDupla n) {
		NoDupla no = first();
		int rank = -1;
		for (int i = 0; i < size(); i++) {
			if (n == no) {
				rank = i;			
			} else {
				no = no.getProximo();							
			}		
			System.out.println(no.getElemento());	
			break;
		}
		return rank;
	}

	public void insertAtRank(int rank, Object elemento) {
		if (rank == size())
			insertLast(elemento);
		else {
			insertBefore(atRank(rank), elemento);
		}
	}

	public Object removeAtRank(int rank) {
		return remove(atRank(rank));
	}

	public Object replaceAtRank(int rank, Object elemento) {
		return replaceElement(atRank(rank), elemento);
	}

	public Object replaceElement(NoDupla no, Object elem) {
		Object temp = no.getElemento();
		no.setElemento(elem);
		return temp;
	}

}