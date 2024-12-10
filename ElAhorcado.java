package elahorcadodawraulalcañizdanieltrillo;

import java.util.Scanner;

public class ElAhorcadoDAWRaulAlcañizDanielTrillo {
    public static Scanner datos=new Scanner (System.in);
    public static String palabra="";
    public static int numErrores=0;
    public static char[] letraErrores=new char [6];
    public static char[] charUsados=new char [25];
    public static int numLetras=0;
    
    
    public static void inicioDibujo(){
        if(numLetras==0){
            System.out.println("<>    <>    <><>     <>      <>      <>>>>>      <>       <>       <><>       <>     <>");
            System.out.println("<>    <>   <>  <>    <>>>    <>     <>     <>    <>>>   <<<>      <>  <>      <>>>   <>");
            System.out.println("<><<>><>  <><<>><>   <>  <>  <>     <>           <>  <<>> <>     <><<>><>     <>  <>  <>");
            System.out.println("<>    <>  <>    <>   <>    <<<>     <>  <<<<     <>   <>  <>     <>    <>     <>    <<<>");
            System.out.println("<>    <>  <>    <>   <>      <>      <>>>>>      <>       <>     <>    <>     <>      <>");
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("Bienvenido al juego del ahorcado!");
            System.out.println("----------------------------------------------------------------------------------------");
        }
        System.out.println("      _______");
        System.out.println("     |/      |");
        
        System.out.println("     |    ");
        if(numErrores>=1){
            System.out.print("(_)");
        }
        System.out.println("     |      ");
        System.out.println("     |       ");
        System.out.println("     |      ");
        System.out.println("     |");
        System.out.println("_____|___");
        System.out.println("----------------------------------------------------------------------------------------");
        
    }
    
    public static void CogerPalabra(){
        String [] palabras= {"","patata","televisor","leclerc"};//Hay que poner 10 después
        int numeroPalabra= (int)(Math.random()*3+1);
        palabra=palabras[numeroPalabra];
    }
    
    public static char pedirLetra(){
        System.out.println("Introduce la letra: ");
        String mami = datos.next();
        char letra=' ';
        for (int x = 0; x < 1;) {
            if(mami.length()>1){
                System.out.println("Solo puedes introducir una letra: ");
                mami=datos.next();
            }else{
                x++;
                letra=mami.charAt(0);
            }
        }
        
        return letra;
    }
    
    public static void inicio(){
        for (int x = 0; x < letraErrores.length; x++) {
            letraErrores[x]=' ';
        }
        for (int x = 0; x < charUsados.length; x++) {
            charUsados[x]=' ';
        }
    }
    
    public static char[] asteriscos( String palabra){
        char[] asteriscos= new char [palabra.length()];
        for(int x=0; x<palabra.length();x++){
            asteriscos[x] = '*';
        }
        return asteriscos;
    }
    
    public static char[] revisarLetra(char letra, char [] asteriscos){
        int coincidencias=0;
        for (int x = 0; x < charUsados.length; x++) {
            if(letra == charUsados[x]){
                System.out.println("Ya has introducido esa letra antes, introduce otra");
                letra = datos.next().charAt(0);
                x = 0;
            }else{
                x++;
            }
        }
        for(int x= 0;x< palabra.length();x++){  
            if(letra == palabra.charAt(x)){
                coincidencias++;
                asteriscos[x] = letra;
            }
        }
        if (coincidencias == 0){
            System.out.println("La letra no estaba en la palabra");
            letraErrores[numErrores] = letra; 
            numErrores++;
        }else{
            System.out.println("La letra estaba en la palabra");
        }
        charUsados[numLetras]=letra;
        numLetras++;
        return asteriscos;
    }
    
    
    
    public static void main(String[] args) {
        inicioDibujo();
        boolean repetir=false;
        int adivinanzas=0;
        inicio();
        CogerPalabra();
        char [] encriptada=asteriscos(palabra);
        System.out.println(palabra);
        System.out.println(encriptada);
        
        char letraRevisar=' ';
        for (int x = 0; x < 6;) {
            adivinanzas=1;
            for (int y = 0; y < encriptada.length; y++) {
                if(encriptada[y]==palabra.charAt(y)){
                    adivinanzas++;
                }
            }
            letraRevisar=pedirLetra();
            encriptada = revisarLetra(letraRevisar, encriptada);
            inicioDibujo();
            System.out.println(palabra);
            System.out.println(encriptada);
            System.out.println("Has cometido " + numErrores + " error/es con las letras: ");
            System.out.println(letraErrores);
            System.out.println("Has usado las Letras: ");
            System.out.println(charUsados);
            if(numErrores>=6)
                x=6;
            if(adivinanzas>=encriptada.length)
                x=6;
        }
    }
    
}
