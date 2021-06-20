public class AppLista {

	public void use() {
		
		Lista lista = new Lista();
		NoDupla no1 = new NoDupla(null,null,null);
		NoDupla no2 = new NoDupla(null,null,null);
		NoDupla no3 = new NoDupla(null,null,null);
		
		
		no1 = lista.inserir(no1,"Joel");
		lista.mostrarNos();
		System.out.println("================");
	  no2 = lista.inserir(no1,"Maykon");
		lista.mostrarNos();
		System.out.println("================");
	  no3 = lista.inserir(no2,"Ribeiro");		
		lista.mostrarNos();
		System.out.println("================");
		System.out.println(lista.isFirst(no1));
		System.out.println(lista.isFirst(no2));
		System.out.println("================");
		System.out.println(lista.isLast(no2));
		System.out.println(lista.isLast(no3));
	
	
	}
}