public class No {

	private Object elemento;
	private No proximo;

	public void setElemento(Object o) {
		elemento = o;
	}

	public Object getElemento() {
		return elemento;

	}

	public void setProximo(No proximo) {
		this.proximo = proximo;
	}

	public No getProximo() {
		return this.proximo;
	}
}