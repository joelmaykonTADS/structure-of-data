public class AppVectorArray {
	public void use() {
		VectorArray vectorArray = new VectorArray(6);
		vectorArray.insertAtRank(0, "A");
		vectorArray.insertAtRank(1, "B");
		vectorArray.insertAtRank(2, "D");
		vectorArray.insertAtRank(3, "E");
		vectorArray.insertAtRank(4, "F");
		System.out.println("=======================");
		vectorArray.mostrarVector();
		System.out.println("=======================");
		vectorArray.insertAtRank(2, "C");
		System.out.println("=======================");
		vectorArray.mostrarVector();
		System.out.println("=======================");
		System.out.println("Posição: 3 Removido: " + vectorArray.removeAtRank(3));
		System.out.println("=======================");
		vectorArray.mostrarVector();
		System.out.println("=======================");
		System.out.println("Posição: 3 Removido: " + vectorArray.removeAtRank(3));
		System.out.println("=======================");
		vectorArray.mostrarVector();
		System.out.println("=======================");
		System.out.println("Elemento antigo: " + vectorArray.replaceAtRank(0, "B") + " Trocado por B");
		System.out.println("Elemento antigo: " + vectorArray.replaceAtRank(1, "A") + " Trocado por A");
		System.out.println("=======================");
		vectorArray.mostrarVector();
		System.out.println("=======================");

		System.out.println("Quantidade inserida: " + vectorArray.quantidadeInserida());
		vectorArray.insertAtRank(2, "L");
		vectorArray.insertAtRank(3, "J");
		vectorArray.insertAtRank(4, "Ç");
		vectorArray.insertAtRank(5, "M");
		System.out.println("=======DUPLICANDO======");
		vectorArray.mostrarVector();
		System.out.println("=======================");
		System.out.println("Quantidade inserida: " + vectorArray.quantidadeInserida());

	}
}