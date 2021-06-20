public class AppFilaArray {

    public void use() throws EVazia {
        IFila fila = new FilaArray(4);
        fila.enfileirar("Joel");
        fila.enfileirar("maykon");
        fila.enfileirar("lis");
        fila.enfileirar("toy");
        fila.mostrarFila();
        fila.desenfileirar();
        fila.mostrarFila();
        fila.enfileirar("houw");
        fila.enfileirar("trosk");
        fila.mostrarFila();
        
    }    
}