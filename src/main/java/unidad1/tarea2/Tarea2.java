package unidad1.tarea2;

import javax.swing.*;
import java.util.Base64;
import java.util.StringTokenizer;


public class Tarea2 {
    public static void main(String[] args) {
        String s,i,t,codificado,decodificado;
        int vocales,cons,digitos,caracteres,espacios,palabras,letras;
        char[] array;
        StringTokenizer tokens;
        byte[] bytesDecodificado;

        s=guardarString("Ingrese un texto");
        do {
            t="";
            tokens=new StringTokenizer(s," ");
            //array=new char[s.length()];
            array=s.toCharArray();
            letras=cons=vocales=digitos=caracteres=espacios=palabras=0;
            codificado=Base64.getEncoder().encodeToString(s.getBytes());
            i = JOptionPane.showInputDialog("Seleccione la opcion deseada:\n" +
                    "1.- Leer String\n" +
                    "2.- Obtener longitud\n" +
                    "3.- Contar letras, vocales y consonantes\n" +
                    "4.- Numero de digitos\n" +
                    "5.- Numero de espacios\n" +
                    "6.- Numero de caracteres especiales\n" +
                    "7.- Numero de palabras\n" +
                    "8.- Convertir a mayusculas\n" +
                    "9.- Convertir a minusculas\n" +
                    "10.- Numero de palabras que inician con vocal\n" +
                    "11.- Invertir string\n" +
                    "12.- Encriptar\n" +
                    "13.- Desencriptar\n" +
                    "0.- Salir", null);
            switch (i){
                case "1":
                    s=guardarString("Ingrese un texto");
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "La logitud del string es "+s.length());
                    break;
                case "3":
                    for (char c:
                            array) {
                        if(Character.isAlphabetic(c)) {
                            letras++;
                        }
                        if(isVocal(c)){
                            vocales++;
                        }
                        if (!isVocal(c) && Character.isAlphabetic(c)) {
                            cons++;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "El string "+s+" tiene "+letras+" letras, "+vocales+" vocales y "+cons+" consonantes");
                    break;
                case "4":
                    for (char c:
                            array) {
                        if(Character.isDigit(c)){
                            digitos++;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "El string "+s+" tiene "+digitos+" digitos");
                    break;
                case "5":
                    for (char c:
                            array) {
                        if(Character.isWhitespace(c)){
                            espacios++;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "El string "+s+" tiene "+espacios+" espacios en blanco");
                    break;
                case "6":
                    for (char c:
                            array) {
                        if(!Character.isLetterOrDigit(c)&&!Character.isWhitespace(c)){
                            caracteres++;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "El string "+s+" tiene "+caracteres+" caracteres especiales");
                    break;
                case "7":
                    JOptionPane.showMessageDialog(null, "El string "+s+" tiene "+tokens.countTokens()+" palabras");
                    break;
                case "8":
                    JOptionPane.showMessageDialog(null,"El texto en mayusculas es "+s.toUpperCase());
                    break;
                case "9":
                    JOptionPane.showMessageDialog(null,"El texto en minusculas es "+s.toLowerCase());
                    break;
                case "10":
                    while (tokens.hasMoreElements()) {
                        if(isVocal(tokens.nextToken().toCharArray()[0])){
                            palabras++;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "El string "+s+" tiene "+palabras+" palabras que comienzan con vocal");
                    break;
                case "11":
                    for (int contador=(s.length()-1);contador>=0;contador--) {
                        t+=s.charAt(contador);
                    }
                    JOptionPane.showMessageDialog(null, "El string "+s+" invertido es "+t);
                    break;
                case "12":
                    JOptionPane.showMessageDialog(null, "El string codificado es "+codificado);
                    break;
                case "13":
                    bytesDecodificado=Base64.getDecoder().decode(codificado);
                    decodificado = new String(bytesDecodificado);
                    JOptionPane.showMessageDialog(null, "El string decodificado es "+decodificado);
                    break;
            }
        }while(!i.equals("0"));
    }
    public static String guardarString(String mensaje){
        return JOptionPane.showInputDialog(mensaje,null).trim();
    }
    public static boolean isVocal(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'|| c == '�'|| c == '�'|| c == '�'|| c == '�'|| c == '�'|| c == 'A'|| c == 'E'|| c == 'I'|| c == 'O'|| c == 'U'|| c == '�'|| c == '�'|| c == '�'|| c == '�'|| c == '�');
    }
}