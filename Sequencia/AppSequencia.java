public class AppSequencia {

	public void use() {
		
		Sequencia lista = new Sequencia();
		NoDupla no1 = new NoDupla(null,null,null);
		NoDupla no2 = new NoDupla(null,null,null);
		NoDupla no3 = new NoDupla(null,null,null);
		
		
		no1 = lista.inserir(null,"Maria");
		lista.mostrarNos();
		System.out.println("================");
	  no2 = lista.inserir(no1,"João");
		lista.mostrarNos();
		System.out.println("================");
	  no3 = lista.inserir(no2,"José");		
		lista.mostrarNos();
		System.out.println("================");
		//System.out.println(lista.isFirst(no1));
	
		System.out.println("================");
		//System.out.println(lista.isLast(no2));

	
		System.out.println("atRank: " + lista.atRank(2).getElemento());
		System.out.println("elementAtRank: " + lista.elemAtRank(2));
		System.out.println("Rank: " + lista.rankOf(no1));
		lista.insertAtRank(2,"Litle Baby");
  	System.out.println("elementAtRank: " + lista.elemAtRank(2));
		lista.mostrarNos();		

		System.out.println(lista.replaceAtRank(3, "João Maria"));
		lista.mostrarNos();

		System.out.println(lista.replaceElement(no3,"Litle Shark" ));
		lista.mostrarNos();

		System.out.println("====================================");
		System.out.println("elementAtRank: " + lista.elemAtRank(4));
		System.out.println("RemoveAtRank: " + lista.removeAtRank(4));
		System.out.println("elementAtRank: " + lista.elemAtRank(4));
		lista.mostrarNos();
	}
}