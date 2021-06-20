public class Lista {
	private NoDupla inicio, fim;
	int tam;

	public Lista() {
		tam = 0;
		
		inicio = new NoDupla(null, null, "inicio");
		fim = new NoDupla(inicio, null, "fim");
		inicio.setProximo(fim);
	}

	public int size() {
		return tam;
	}

	public boolean isFirst(NoDupla n) {
		return n.getAnterior() == inicio;
	}

	public boolean isLast(NoDupla n) {
		return n.getProximo() == fim;
	}

	public boolean isEmpty() {
		return tam == 0;
	}

	public NoDupla inserir(NoDupla n, Object elemento) {
		if (isEmpty()) {
			tam++;
			return insertFirst(elemento);
		} else {
			tam++;
			return insertAfter(n, elemento);
		}
	}

	public NoDupla insertAfter(NoDupla p, Object elemento) {
		tam++;
		NoDupla novo = new NoDupla(p, p.getProximo(), elemento);
		(p.getProximo()).setAnterior(novo);
		p.setProximo(novo);
		return novo;
	}
	public NoDupla insertBefore(NoDupla n, Object elemento)
	{    
		// 1º inicialmente a aponta para c e vice-versa: [a] < > [c] 
		// 2º b aponta para a e c:  [a]  < [b] >  [c]
		// 3º para defazer a referência entre a e c: [a] x x [c]
		// 4º a aponta para b e c aponta para b [a] > [b] && [c] > [b]
    tam++;
    NoDupla no = new NoDupla(n.getAnterior(), n, elemento);
    (n.getAnterior()).setProximo(no);
    n.setAnterior(no);
    return no;
  }
	public NoDupla insertFirst(Object element) {
		tam++;
		NoDupla novo = new NoDupla(inicio, inicio.getProximo(), element);
		inicio.getProximo().setAnterior(novo);
		inicio.setProximo(novo);
		return novo;
	}
	public NoDupla insertLast(Object element) {
		tam++;
		NoDupla novo = new NoDupla(fim.getAnterior(), fim, element);
		fim.getAnterior().setProximo(novo);
		fim.setAnterior(novo);
		return novo;
	}
	public Object remove(NoDupla n){
		Object temp = n.getElemento();
		n.getAnterior().setProximo(n.getProximo());
		n.getProximo().setAnterior(n.getAnterior());
		n.setAnterior(null);
		n.setProximo(null);
		return temp;
	}
	public void mostrarNos() {
		NoDupla temp;
		temp = inicio;
		do {
			System.out.println("Elemento :" + temp.getElemento());
			temp = temp.getProximo();
		} while (temp != fim);
		System.out.println("Elemento :" + fim.getElemento());

	}	

	public NoDupla first() {
		return inicio.getProximo();
	}

	public NoDupla last() {
		return fim.getAnterior();
	}

	public NoDupla before(NoDupla n) {
		return n.getAnterior();
	}

	public NoDupla after(NoDupla n) {
		return n.getProximo();
	}

	public Object replace(NoDupla n, Object elemento) {
		Object antigoElemento = n.getElemento();
		n.setElemento(elemento);
		return antigoElemento;
	}

	public void swapElements(NoDupla n, NoDupla q) {
		Object temp = n.getElemento();
		n.setElemento(q.getElemento());
		q.setElemento(temp);
	}

}