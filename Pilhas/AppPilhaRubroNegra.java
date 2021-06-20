public class AppPilhaRubroNegra {
    public void use(){
        IPilhaRubroNegra pilhaRubroNegra = new PilhaRubroNegra(1);
        pilhaRubroNegra.pushRubro("1 rubro");
        pilhaRubroNegra.all();
        pilhaRubroNegra.pushRubro("2 rubro");
        pilhaRubroNegra.all();
        pilhaRubroNegra.pushRubro("3 rubro");
        pilhaRubroNegra.all();        
       
        pilhaRubroNegra.pushNegro("1 negro");
        pilhaRubroNegra.all();
        
        
        IPilhaRubroNegra pilhaRubroNegra2 = new PilhaRubroNegra(1);
        pilhaRubroNegra2.pushRubro("Item 1");
        pilhaRubroNegra2.all();
        pilhaRubroNegra2.pushNegro("Item 2");
        pilhaRubroNegra2.all();
        pilhaRubroNegra2.pushRubro("Item 3");
        pilhaRubroNegra2.all();
        pilhaRubroNegra2.pushNegro("Item 4");
        pilhaRubroNegra2.all();
     
       
    }
    
}