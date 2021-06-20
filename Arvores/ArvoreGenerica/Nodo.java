import java.util.ArrayList;
import java.util.Iterator;

public class Nodo {
	private Object elemento;
	private int key;
	private Nodo pai;
	public Nodo esquerdo, direito;
	private ArrayList filhos = new ArrayList();
	
	public Nodo(Object elemento, Nodo pai) {
		this.pai = pai;
		this.elemento = elemento;
	}
	public Nodo(int key){		
		this.key = key;
		esquerdo = direito = null;
	}
	public Object element() {
		return elemento;
	}
	public int key(){
		return key;
	}
	public void setPai(Nodo pai){
		this.pai = pai;
	}
	public Nodo leftChild(Nodo v){
		return v.esquerdo;
	}
	public Nodo rightChild(Nodo v){
		return v.direito;
	}

	public Nodo parent() {
		return pai;
	}

	public void setElement(Object elemento) {
		this.elemento = elemento;
	}
	public void addChild(Nodo nodo) {
			filhos.add(nodo);
	}

	public void removeChild(Nodo nodo) {
		filhos.remove(nodo);
	}

	public int childrenNumber() {
		return filhos.size();
	}

	public ArrayList children() {			
		return filhos;
	}
}