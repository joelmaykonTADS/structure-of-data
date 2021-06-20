public class AppFilaSimplementeEncadeada {
    public void use(){
        FilaSimplesmenteEncadeada fila = new FilaSimplesmenteEncadeada();
        fila.enfileirar("Joel");
        fila.mostrar();
        fila.enfileirar("Maykon");
        fila.mostrar();
        fila.enfileirar("Ribeiro");
        fila.mostrar();
        fila.desenfileirar();
        fila.mostrar();
    }
    
}