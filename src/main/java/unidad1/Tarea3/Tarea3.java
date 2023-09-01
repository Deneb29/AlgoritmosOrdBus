package unidad1.Tarea3;

import javax.swing.*;
import java.util.Random;
import java.util.regex.*;

public class Tarea3 {
    public static void main(String[] args) {
        String i,s,pssw;
        Boolean isRight;
        int contador;

        contador=0;
        s=guardarString("Ingrese una contraseña");
        do{
            i= JOptionPane.showInputDialog("Seleccione la opcion deseada:\n" +
                    "1.- Ingresar contraseña\n" +
                    "2.- Validar contraseña\n" +
                    "3.- Ver seguridad de la contraseña\n" +
                    "4.- Generar contraseña\n" +
                    "0.- Salir",null);

            switch (i){
                case "1":
                    s=guardarString("Ingrese una contraseña");
                    break;
                case "2":
                    isRight=Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[$#@.&!]).{8,12}$",s);
                    if (isRight && !s.contains(" ")){
                        JOptionPane.showMessageDialog(null,"Su contraseña es correcta");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Su contraseña no es correcta");
                    }
                    break;
                case "3":
                    if(s.length()>10){
                        contador++;
                    }
                    if(s.length()>15){
                        contador++;
                    }
                    for(int j=0;j<s.length();j++) {
                        if (s.charAt(j) == '$' || s.charAt(j) == '#' || s.charAt(j) == '@' || s.charAt(j) == '.' || s.charAt(j) == '&' || s.charAt(j) == '!') {
                            contador++;
                        }
                    }
                        //Maxima puntuacion 16 minima 1
                        if(contador<=4){
                            JOptionPane.showMessageDialog(null, "Su contraseña es debil");
                        }
                        else if(contador<=12){
                            JOptionPane.showMessageDialog(null, "Su contraseña es fuerte");
                        }
                        else if(contador<=16){
                            JOptionPane.showMessageDialog(null, "Su contraseña es muy fuerte");
                        }
                    break;

                case "4":
                    pssw=generarLetras(3)+generarNum(2)+generarSimbolos(3)+generarLetras(5)+generarSimbolos(1)+generarSimbolos(3);
                    JOptionPane.showMessageDialog(null,pssw);

                    break;
            }
        }while(!i.equals("0"));
    }
    public static String guardarString(String mensaje){
        return JOptionPane.showInputDialog(mensaje,null).trim();
    }
    public static String generarLetras(int num){
        String s="";
        Random random=new Random();
        for(int i=0;i<num;i++){
            if(random.nextBoolean()){
                s+=(char)(random.nextInt(90-65)+65);
            }
            else {
                s+=(char)(random.nextInt(122-97)+97);
            }
        }
        return s;
    }
    public static String generarNum(int num){
        String s="";
        Random random=new Random();
        for(int i=0;i<num;i++){
                s+=(random.nextInt(9));
        }
        return s;
    }
    public static String generarSimbolos(int num){
        String s="";
        Random random=new Random();
        char[]simbolos={'$','#','@','.','&','!'};
        for(int i=0;i<num;i++){
            s+=simbolos[random.nextInt(5)];
        }
        return s;
    }
}
