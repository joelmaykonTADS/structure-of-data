import java.util.ArrayList;
import static java.lang.Integer.max;

public class ArvoreBinaria {
	public Nodo raiz, pai;
	int size = 0;
	ArrayList lista = new ArrayList();
  ArrayList nos_altura = new ArrayList();
  ArrayList nos_elementos = new ArrayList();

	public Nodo search(Nodo no, int key) {
		if (no == null || no.key() == key) {
			return no;
		}
		if (no.key() > key) {
			return search(no.esquerdo, key);
		}
		return search(no.direito, key);
	}

	public ArrayList<Nodo> children(Nodo n) {
        ArrayList<Nodo> a = new ArrayList();
        if(n.esquerdo != null)
          a.add(n.esquerdo);
        if(n.direito != null)        
          a.add(n.direito);
        return a;
    }

	
  public int size() {
		return size;
	}

	public Nodo inserirNo(int key) {
		raiz = insert(raiz, key);
		size++;
		return raiz;
	}

	public Nodo insert(Nodo pai, int key) {
		if (pai == null) {
			pai = new Nodo(key);
			size++;
		}
		else if (key < pai.key()){
			pai.esquerdo = insert(pai.esquerdo, key);
		}else{
			pai.direito = insert(pai.direito, key);
		}
		return pai;
	}

	public boolean isEmpty() {
		return raiz == null;
	}

	public boolean isRoot(Nodo no) {
		return no == raiz;
	}

  public int height(Nodo n) {
        if(isExternal(n))
            return 0;
        else{
            int h = 0;
            for(Nodo x : children(n)){
                h = max(h, height(x));
            }
            return ++h;
        }
  }

	public Nodo root() {
		return raiz;
	}

	public ArrayList elements() {
		lista.clear();
		preOrderElements(root());
		return lista;
	}

	public ArrayList nos() {
		lista.clear();
		preOrderNos(root());
		return lista;
	}

	public Nodo isLeft(Nodo n) {
		return n.esquerdo;
	}

	public Nodo isRight(Nodo n) {
		return n.direito;
	}

	public void print() {
		print(raiz, "");
	}
 
	private void print(Nodo no, String indent) {
		if (no != null) {
			print(no.esquerdo, indent + "----");
			System.out.println("\n" + indent + no.key());
			print(no.direito, indent + "----");
		}
	}
	
	public boolean isExternal(Nodo no) {
		if (no.esquerdo == null && no.direito == null) {
			return true;
		}
		return false;
	}

	public boolean isInternal(Nodo no) {
		if (no != null) {
			return true;
		}
		return false;
	}

	public void preOrder(Nodo no) {
		System.out.println("preOrder: " + no.key());
		Nodo esquerdo = no.leftChild(no);
		Nodo direito = no.rightChild(no);
		if (isInternal(esquerdo))
			preOrder(esquerdo);
		if (isInternal(direito))
			preOrder(direito);
	}

	public void preOrderElements(Nodo no) {
		lista.add(no);
		Nodo esquerdo = no.leftChild(no);
		Nodo direito = no.rightChild(no);
		if (isInternal(esquerdo))
			preOrderElements(esquerdo);
		if (isInternal(direito))
			preOrderElements(direito);
	}

	public void preOrderNos(Nodo no) {
    System.out.println(no);
    System.out.println(no.key());
		lista.add(no);
		Nodo esquerdo = no.leftChild(no);
		Nodo direito = no.rightChild(no);
		if (isInternal(esquerdo))
			preOrderNos(esquerdo);
		if (isInternal(direito))
			preOrderNos(direito);
	}

	public void posOrder(Nodo no) {
		Nodo esquerdo = no.leftChild(no);
		Nodo direito = no.rightChild(no);
		if (esquerdo != null)
			posOrder(esquerdo);
		if (direito != null)
			posOrder(direito);
		System.out.println("posOrder: " + no.key());
	}

	public void inOrder(Nodo no) {
		Nodo esquerdo = no.leftChild(no);
		Nodo direito = no.rightChild(no);
		if (esquerdo != null)
			inOrder(esquerdo);
		System.out.println("InOrder: " + no.key());
		if (direito != null)
			inOrder(direito);
	}

  public Nodo parent(Nodo v) {
		Nodo pai = raiz;
		if (v != null) {
			if (v == raiz) {
				return root();
			}
			if (pai.esquerdo == v) {
				return pai;		
			} else if (pai.direito != v) {
				pai = parent(pai.direito);				
			}
		}
		return pai;
	}

  public int depth(Nodo no) {
			if (no == raiz) {
				return 0;
			} else {
				return 1 + depth(parent(no));
			}		
	}
  
  public void imprimirArvore(Nodo no) {    
		Nodo esquerdo = no.leftChild(no);
		Nodo direito = no.rightChild(no);
		if (esquerdo != null)
			imprimirArvore(esquerdo);
		System.out.println("No: " + no + " profundidade: "+ depth(no));
    nos_altura.add(no);
    nos_elementos.add(no.key());
		if (direito != null)
			imprimirArvore(direito);
	}

 public void mostrar(){ 
        imprimirArvore(raiz);  
        System.out.println(height(raiz));   
        System.out.println(nos_elementos.size());
        int linhas = height(raiz);
        int colunas = nos_elementos.size();     
        int matriz[][] = new int[linhas][colunas];
        for(int i = 0; i < nos_elementos.size(); i++){
          int num = (Integer)nos_elementos.get(i);
          matriz[depth( (Nodo)nos_altura.get(i)  )][i] = num;
        }
        System.out.println();   
        /*     
        for(int i = 0; i < linhas; i++){
            for(int j = 0; j < colunas; j++){
                if(matriz[i][j] != 0){
                    System.out.print(matriz[i][j] + "\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
        System.out.println();
        */
        for(int i = 0; i < linhas; i++){
            for(int j = 0; j < colunas; j++){
              System.out.print(matriz[i][j]);
            }
            System.out.println();
          }

    }
}