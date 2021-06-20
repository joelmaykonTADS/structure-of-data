public class AppPilhaEncadeada {
    public void use(){
        PilhaSimplesmenteEncadeada pilha = new PilhaSimplesmenteEncadeada();
        pilha.empilhar("1º Joel");
        pilha.empilhar("2º Maykon");
        pilha.empilhar("3º Ribeiro");        
        pilha.mostrar();                
        pilha.desempilhar();        
        pilha.mostrar();
    }
    
}