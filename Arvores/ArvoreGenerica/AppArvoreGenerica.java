import java.util.Vector;
import java.util.ArrayList;
import java.util.Iterator;

public class AppArvoreGenerica {
	public void use() {	
		
		ArvoreGenerica arvoreGen = new ArvoreGenerica("Root");
		Nodo raiz = arvoreGen.raiz;

		Nodo nodo1 = arvoreGen.addChild("1",raiz);
		Nodo nodo2 = arvoreGen.addChild("2", nodo1);
		Nodo nodo3 = arvoreGen.addChild("3",nodo2);
		Nodo nodo4 = arvoreGen.addChild("4",nodo1);
		Nodo nodo5 = arvoreGen.addChild("5",nodo3);
		
		System.out.println("Tamanho da arvore: " + arvoreGen.size());
		System.out.println("___________ Pré ordenado ________");	
		ArrayList<Nodo> arvorePreElement = arvoreGen.elements();
		for(int i = 0; i < arvorePreElement.size(); i++){
			if(arvorePreElement.get(i) != raiz.element()){
				System.out.println("Filho: " + arvorePreElement.get(i));
			}else{
				System.out.println("Raiz: " + arvorePreElement.get(i));
			}			
		}	
		System.out.println("___________ Pós ordenado ________");	
		ArrayList<Nodo> arvorePosElement = arvoreGen.posElements();
		for(int i = 0; i < arvorePosElement.size(); i++){
			if(arvorePosElement.get(i) != raiz.element()){
				System.out.println("Filho: " + arvorePosElement.get(i));
			}else{
				System.out.println("Raiz: " + arvorePosElement.get(i));
			}			
		}		
		System.out.println("Profundidade do elemento " + nodo1.element() + " é: " + arvoreGen.depth(nodo1));
		System.out.println("Profundidade do elemento " + nodo2.element() + " é: " + arvoreGen.depth(nodo2));
		System.out.println("Profundidade do elemento " + nodo3.element() + " é: " + arvoreGen.depth(nodo3));
		System.out.println("Profundidade do elemento " + nodo4.element() + " é: " + arvoreGen.depth(nodo4));
		System.out.println("Profundidade do elemento " + nodo5.element() + " é: " + arvoreGen.depth(nodo5));
		System.out.println("Altura é: " + arvoreGen.height());

		arvoreGen.swapElements(nodo1, nodo5);
		for(int i = 0; i < arvorePreElement.size(); i++){
			if(arvorePreElement.get(i) != raiz.element()){
				System.out.println("Filho: " + arvorePreElement.get(i));
			}else{
				System.out.println("Raiz: " + arvorePreElement.get(i));
			}			
		}	
	}
}