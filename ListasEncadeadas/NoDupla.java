
public class NoDupla {

	private Object elemento;
	private NoDupla anterior, proximo;

	public NoDupla(NoDupla novoAnterior, NoDupla novoProximo, Object element) {
		anterior = novoAnterior;
		proximo = novoProximo;
		elemento = element;
	}

	public void setElemento(Object o) {
		this.elemento = o;
	}

	public void setAnterior(NoDupla no) {
		this.anterior = no;
	}

	public void setProximo(NoDupla no) {
		this.proximo = no;
	}

	public Object getElemento() {
		if ((anterior == null) && (proximo == null))
			System.out.println("Elemento sem referência!");
		return this.elemento;
	}

	public NoDupla getProximo() {
		return this.proximo;
	}

	public NoDupla getAnterior() {
		return this.anterior;
	}
}
