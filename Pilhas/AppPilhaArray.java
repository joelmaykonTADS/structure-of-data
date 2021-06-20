public class AppPilhaArray {
    public void use() {
        IPilhaArray pilha = new PilhaArray(2);
        System.out.println(pilha.size());
        pilha.push("Joel");
        pilha.all();
        pilha.push("Maykon");
        pilha.all();
        pilha.push("Ribeiro"); 
				pilha.all();      
        pilha.pop();
				pilha.all();
        pilha.push("Souza");
        pilha.push("Maykon");
        pilha.push("Ribeiro");
        pilha.push("Lima");
        pilha.all();

    }
}