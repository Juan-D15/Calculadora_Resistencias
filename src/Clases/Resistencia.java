package Clases;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
 * @author juani
 */

//Resistencia de 4 Bandas
public class Resistencia {
    //atributos
    protected int banda1;
    protected int banda2;
    private String multiplicador;
    private String tolerancia;

    
    //get = obtener  set = colocar
    public int getBanda1() {
        return banda1;
    }

    public void setBanda1(int banda1) {
        this.banda1 = banda1;
    }

    public int getBanda2() {
        return banda2;  
    }

    public void setBanda2(int banda2) {
        this.banda2 = banda2;
    }
       
    public String getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(String multiplicador) {
        this.multiplicador = multiplicador;
    }

    public String getTolerancia() {
        return tolerancia;
    }

    public void setTolerancia(String tolerancia) {
        this.tolerancia = tolerancia;
    }
    
    //simbolos de los valores de las resistencias
    public String simboloOhm(){
        String Ohm = " Ω";
        return Ohm;
    }
    public String simboloKohm(){
        String Kohm = " kΩ";
        return Kohm;
    }            
    public String simboloMohm(){
        String Mohm = " MΩ";
        return Mohm;
    }
    public String simboloGohm(){
        String Gohm = " GΩ";
        return Gohm;
    }      
    //junta la banda1 y banda2
    public String juntarBandas(){
        String valor1 = Integer.toString(banda1);
        String valor2 = Integer.toString(banda2);
        String Bandasjuntas = valor1+valor2;
        return Bandasjuntas;
    }
    //determina que valor tiene el multiplicador segun la lista
    public String valoresMultiplicador(){
        switch(multiplicador){
            case "0" -> this.multiplicador = "1";          //Negro
            case "1" -> this.multiplicador = "10";         //Marrón
            case "2" -> this.multiplicador = "100";        //Rojo
            case "3" -> this.multiplicador = "1000";       //Naranja
            case "4" -> this.multiplicador = "10000";      //Amarillo
            case "5" -> this.multiplicador = "100000";     //Verde
            case "6" -> this.multiplicador = "1000000";    //Azul
            case "7" -> this.multiplicador = "10000000";   //Violeta
            case "8" -> this.multiplicador = "100000000";  //Gris
            case "9" -> this.multiplicador = "1000000000"; //Blanco
            case "10" -> this.multiplicador = "0.1";       //Oro
            case "11" -> this.multiplicador = "0.01";      //Plata
            default -> this.multiplicador = "0";
        }
        return multiplicador; 
                
    }
    //valores de la tolerancia
    public String valoresTolerancia(){
        String[] Tolerancias = {" ±1%"," ±2%"," ±0.5%"," ±0.25%"," ±0.10%"," ±0.05%"," ±5%"," ±10%"," ±20%"};
        switch(tolerancia){
            case "0" -> this.tolerancia = Tolerancias[0];   //Marrón
            case "1" -> this.tolerancia = Tolerancias[1];   //Rojo
            case "2" -> this.tolerancia = Tolerancias[2];   //Verde
            case "3" -> this.tolerancia = Tolerancias[3];   //Azul
            case "4" -> this.tolerancia = Tolerancias[4];   //Violeta
            case "5" -> this.tolerancia = Tolerancias[5];   //Gris
            case "6" -> this.tolerancia = Tolerancias[6];   //Oro
            case "7" -> this.tolerancia = Tolerancias[7];   //Plata
            case "8" -> this.tolerancia = Tolerancias[8];   //Sin Banda
            default -> this.tolerancia = "0";
        }
        return tolerancia;
    }
    
    //CALCULO
    public String Calculo(){
        //convierte el valor a un double
        double n1 = Double.parseDouble(juntarBandas());
        double n2 = Double.parseDouble(valoresMultiplicador());
        //calculo de la resistencia
        double resultado = n1*n2;
        //Redondear valores con muchos decimales a valores con el rango 0.00
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        String calculo = df.format(resultado);
        
        return calculo;
    }
    public String multiplicacion(){
        //convierte el string a double
        double result = Double.parseDouble(Calculo());
        
        //condicion para reducir el valor a KΩ o Ω
        if(result >=1000 && result < 1000000){
            return (result/1000)+simboloKohm()+valoresTolerancia();       //kΩ
        }
        
        else if (result>=1000000 && result < 1000000000){
            return (result/1000000)+simboloMohm()+valoresTolerancia();    //MΩ
        }
        
        else if(result >=1000000000){
            return (result/1000000000)+simboloGohm()+valoresTolerancia(); //GΩ
        }
        
        else{
            return result+simboloOhm()+valoresTolerancia(); //Ω
        }
    }
  }