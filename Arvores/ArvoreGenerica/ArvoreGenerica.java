import java.util.ArrayList;
import java.util.Iterator;

public class ArvoreGenerica {
	Nodo raiz;
	int tamanho;
	private ArrayList lista = new ArrayList();

	

	public ArvoreGenerica(Object o) {
		raiz = new Nodo(o, null);
		tamanho = 1;
	}

	public Nodo root() {
		return raiz;
	}

	public Nodo parent(Nodo v) {
		Nodo n = (Nodo) v;
		return n.parent();
	}

	public ArrayList children(Nodo v) {
		Nodo n = (Nodo) v;
		return n.children();
	}

	public boolean isInternal(Nodo v) {
		Nodo n = (Nodo) v;
		return (n.childrenNumber() > 0);
	}

	public boolean isExternal(Nodo v) {
		Nodo n = (Nodo) v;
		return (n.childrenNumber() == 0);
	}

	public boolean isRoot(Nodo v) {
		Nodo n = (Nodo) v;
		return n == raiz;
	}

	public Nodo addChild(Object elemento, Nodo pai) {
		Nodo n = new Nodo(elemento, pai);
		pai.addChild(n);
		tamanho++;
		return n;
	}

	public Object remove(Nodo v) {
		Nodo n = (Nodo) v;
		Nodo pai = n.parent();
		if (pai.parent() != null || isExternal(n))
			pai.removeChild(n);
		else
			System.out.print("Posição invalida");
		Object o = n.element();
		tamanho--;
		return o;
	}

	public int depth(Nodo v) {
		Nodo n = (Nodo) v;
		int profundidade = profundidade(n);
		return profundidade;
	}

	private int profundidade(Nodo n) {
		if (n == raiz)
			return 0;
		else
			return 1 + profundidade(n.parent());
	}

	// no folhas longe do raiz
	public int height() {
		int altura = 0;
		if (isExternal(raiz)) {
			return altura;
		} else {
			altura = 0;
			ArrayList listaNos = nos();
			for(int i = 0; i < listaNos.size(); i++){
				int profundidade = depth((Nodo)listaNos.get(i));
				if(profundidade > altura){
					altura = profundidade;
				}
			}
			return altura;
		}
	}

	// trocar elementos do no
	public void swapElements(Nodo v, Nodo w) {
		Nodo temp = new Nodo(null, null);
		temp = v;
		v.setElement(w.element());
		w.setElement(temp.element());
	}

	public int size() {
		return tamanho;
	}

	public boolean isEmpty() {
		return false;
	}

	// trocar o elemento antigo por um novo elemento (o)
	public Object replace(Nodo v, Object o) {
		return o;
	}

	public ArrayList nos() {
		lista.clear();
		preOrderNos(root());
		return lista;
	}

	public ArrayList elements() {
		lista.clear();
		preOrderElements(root());
		return lista;
	}
	public ArrayList posElements() {
		lista.clear();
		posOrderElements(root());
		return lista;
	}

	public void preOrderElements(Nodo v) {
		lista.add(v.element());
		ArrayList<Nodo> filhos = v.children();
		for (int filho = 0; filho < v.childrenNumber(); filho++) {
			preOrderElements(filhos.get(filho));
		}
	}
	public void posOrderElements(Nodo v) {		
		ArrayList<Nodo> filhos = v.children();
		for (int filho = 0; filho < v.childrenNumber(); filho++) {
			preOrderElements(filhos.get(filho));
		}
		lista.add(v.element());
	}

	public void preOrderNos(Nodo v) {
		lista.add(v);
		ArrayList<Nodo> filhos = v.children();
		for (int filho = 0; filho < v.childrenNumber(); filho++) {
			preOrderNos(filhos.get(filho));
		}
	}

}
