package Clases;

/**
 *
 * @author juani                             
 */

//Resistencia de 5 Bandas
public class Resistencia2 extends Resistencia{    
    private int banda3; 
    
    public int getBanda3() {
        return banda3;
    }

    public void setBanda3(int banda3) {
        this.banda3 = banda3;
    }
    
    //simbolos de los valores de las resistencias      
    //junta la banda1, banda2 y banda3
    @Override
    public String juntarBandas(){
        String valor1 = Integer.toString(banda1);
        String valor2 = Integer.toString(banda2);
        String valor3 = Integer.toString(banda3);
        String Bandasjuntas = valor1+valor2+valor3;
        return Bandasjuntas;
    }       
}

  