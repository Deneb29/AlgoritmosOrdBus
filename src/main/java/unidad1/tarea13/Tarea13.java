package unidad1.tarea13;

import javax.swing.*;
import java.util.Arrays;
import java.util.Random;

public class Tarea13 {
    public static void main(String[] args) {
        String [] palabras= {"PERRO","GATO","RATON","PEZ","CABALLO","LEON","TIGRE","BALLENA","ELEFANTE","MONO","LOBO","AGUILA","TORTUGA","VACA","OSO","PERICO","SERPIENTE","PINGUINO","CABRA","JAGUAR"};
        int vidas=5;
        int r;
        String output="";
        String input,palabra,letra;
        char[]palabrac;

        r=new Random().nextInt(20);
        palabra=palabras[r];
        palabrac=new char[palabra.length()];
        Arrays.fill(palabrac,' ');
        for (int i=0;i<palabra.length();i++){
            output+="_ ";
        }
        do{
            input=JOptionPane.showInputDialog(null,"Juego del ahorcado\n"+
                    "Adivine una letra de la palabra. Temática: Animales\n"+
                    "INGRESE SOLO UNA LETRA. SI INGRESA MAS DE UNA SE TOMARA EN CUENTA SOLO LA PRIMERA\n"+
                    "Ingrese 0 para salir\n"+
                    output+"\n"+
                    "Vidas restantes: "+vidas
                    );
            letra=String.valueOf(input.charAt(0)).trim().toUpperCase();
            if(palabra.contains(letra)){
                for(int i=0;i<palabra.length();i++){
                    if(palabra.charAt(i)==letra.charAt(0)){
                        palabrac[i]=letra.charAt(0);
                    }
                }
                output="";
                for(char c : palabrac){
                    if(c==' '){
                        output+="_ ";
                    }
                    else{
                        output+=c;
                    }
                }
                //output=palabra.replaceAll("[^"+letra+"]","_ ");
                JOptionPane.showMessageDialog(null,"Letra adivinada");
            }
            else{
                if(!input.equals("0")){
                    vidas--;
                    JOptionPane.showMessageDialog(null,"La letra no esta en la palabra");
                }
            }
        }while(vidas>0 && output.contains("_ ") && !input.equals("0"));

        if(vidas==0){
            JOptionPane.showMessageDialog(null,"Se acabaron sus intentos. La palabra era: "+palabra);
        }
        if(!output.contains("_ ")){
            JOptionPane.showMessageDialog(null,"Ha ganado");
        }
    }
}
