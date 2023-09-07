package unidad1.tarea4;

import javax.swing.*;
import java.util.StringTokenizer;


public class Tarea4 {
    public static void main(String[] args) {
        String s,i;
        String [] nombres=new String[5];
        String res="";

        s=guardarString("Ingrese un texto");
        for (int j=0;j< nombres.length;j++) {
            nombres[j]=guardarString("Ingrese un texto");
        }

        do {
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
                    "14.- Encriptar JULIO VERNE \n" +
                    "15.- Desencriptar JULIO VERNE\n" +
                    "0.- Salir", null);
            switch (i){
                case "1":
                    for (int j=0;j< nombres.length;j++) {
                        nombres[j]=guardarString("Ingrese un texto");
                    }
                    break;
                case "2":
                    getLongitud(nombres);
                    break;
                case "3":
                    getLetras(nombres);
                    break;
                case "4":
                    getDigitos(nombres);
                    break;
                case "5":
                    getEspacios(nombres);
                    break;
                case "6":
                    getCaracteres(nombres);
                    break;
                case "7":
                    getPalabras(nombres);
                    break;
                case "8":
                    aMayusculas(nombres);
                    break;
                case "9":
                    aMinusculas(nombres);
                    break;
                case "10":
                    iniciaVocal(nombres);
                    break;
                case "11":
                    invertirString(nombres);
                    break;
                case "12":
                    res="";
                    for (int j=0;j< nombres.length;j++) {
                        res+=construirString(codificacion(nombres[j]));
                    }
                    JOptionPane.showMessageDialog(null, "Los strings codificados son " + res);
                    break;
                case "13":
                    decodificacion(nombres);
                    break;
                case "14":
                    res="";
                    for (int j=0;j< nombres.length;j++) {
                        res+=construirString(codificacionJV(nombres[j]));
                    }
                    JOptionPane.showMessageDialog(null, "Los strings codificados son " + res);
                    break;
                case "15":
                    decodificacionJV(nombres);
                    break;
            }
        }while(!i.equals("0"));
    }
    public static String guardarString(String mensaje){
        return JOptionPane.showInputDialog(mensaje,null).trim();
    }
    public static boolean isVocal(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'|| c == 'á'|| c == 'é'|| c == 'í'|| c == 'ó'|| c == 'ú'|| c == 'A'|| c == 'E'|| c == 'I'|| c == 'O'|| c == 'U'|| c == 'Á'|| c == 'É'|| c == 'Í'|| c == 'Ó'|| c == 'Ú');
    }
    public static void getLongitud(String[] s){
        String res="";
        for (int j=0;j< s.length;j++) {
            res+=construirString(String.valueOf(s[j].length()));
        }
        JOptionPane.showMessageDialog(null, "Las longitudes son \n"+res);
    }
    public static String codificacionJV(String s){
        // agarrar for de los metodos cambiados, meter todo el codigo dentro, cambiar las variables necesarias, guardar el resultado
        //en res dentro del for con construirString, imprimir res despues del for
        String codificado = s.replace(' ', '%');
        String codificado2="";
        String [] codarray={"","","","",""};
        String clave="JULIO";
        int[]pos={2,5,3,1,4};
        char lts[][] =new char[20][clave.length()];
        int l=0;
        for (int j=0;j<20;j++) {
            for(int k=0;k<clave.length();k++){
                if(l< codificado.length()) {
                    lts[j][k] = codificado.charAt(l);
                }
                l++;
            }
        }
        for(int col=0;col<clave.length();col++) {
            int m=pos[col]-1;
            for (int fila = 0; fila < 20; fila++) {
                if(lts[fila][col] != 0){
                    codarray[m]+=lts[fila][col];
                }
            }
        }
        for (String st:
                codarray) {
            codificado2+=st;
        }
        return codificado2;
    }
    public static void getLetras(String[] s){
        String res="";
        for (int j=0;j< s.length;j++) {
            int vocales,cons,letras;
            char[] array;
            array=s[j].toCharArray();
            letras=cons=vocales=0;
            for (char c: array) {
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
            res+=construirString("El string "+s[j]+" tiene "+letras+" letras, "+vocales+" vocales y "+cons+" consonantes");
        }

        JOptionPane.showMessageDialog(null, "Las letras son \n"+res);
    }
    public static void getDigitos(String[] s){
        String res="";
        for (int j=0;j< s.length;j++) {
            char[] array;
            int digitos;
            array=s[j].toCharArray();
            digitos=0;
            for (char c : array) {
                if(Character.isDigit(c)){
                    digitos++;
                }
            }
            res+=construirString("El string "+s[j]+" tiene "+digitos+" digitos");
        }
        JOptionPane.showMessageDialog(null, "Los digitos son \n"+res);
    }
    public static void getEspacios(String[] s){
        String res="";
        for (int j=0;j< s.length;j++) {
            char[] array;
            int espacios;
            array = s[j].toCharArray();
            espacios = 0;
            for (char c :
                    array) {
                if (Character.isWhitespace(c)) {
                    espacios++;
                }
            }
            res+=construirString("El string " + s[j] + " tiene " + espacios + " espacios en blanco");
        }
        JOptionPane.showMessageDialog(null, "Los espacios en blanco son \n"+res);
    }
    public static void getCaracteres(String[] s){
        String res="";
        for (int j=0;j< s.length;j++) {
            char[] array;
            int caracteres;
            array = s[j].toCharArray();
            caracteres = 0;
            for (char c :
                    array) {
                if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                    caracteres++;
                }
            }
            res+=construirString("El string " + s[j] + " tiene " + caracteres + " caracteres especiales");
        }
        JOptionPane.showMessageDialog(null, "Los caracteres especiales son \n"+res);
    }
    public static void getPalabras(String[] s){
        String res="";
        for (int j=0;j< s.length;j++) {
            StringTokenizer tokens;
            tokens = new StringTokenizer(s[j], " ");
            res+=construirString("El string " + s[j] + " tiene " + tokens.countTokens() + " palabras");
        }
        JOptionPane.showMessageDialog(null, "Los numeros de palabras son\n"+res);
    }
    public static void aMayusculas(String[] s){
        String res="";
        for (int j=0;j< s.length;j++) {
            res+=construirString("El texto en mayusculas es " + s[j].toUpperCase());
        }
        JOptionPane.showMessageDialog(null, "Las palabras en mayusculas son\n"+res);
    }
    public static void aMinusculas(String[] s){
        String res="";
        for (int j=0;j< s.length;j++) {
            res+=construirString("El texto en mayusculas es " + s[j].toLowerCase());
        }
        JOptionPane.showMessageDialog(null, "Las palabras en minusculas son\n"+res);
    }
    public static void iniciaVocal(String[] s){
        String res="";
        for (int j=0;j< s.length;j++) {
            StringTokenizer tokens;
            int palabras;
            tokens = new StringTokenizer(s[j], " ");
            palabras = 0;

            while (tokens.hasMoreElements()) {
                if (isVocal(tokens.nextToken().toCharArray()[0])) {
                    palabras++;
                }
            }
            res+=construirString("El string " + s[j] + " tiene " + palabras + " palabras que comienzan con vocal");
        }
        JOptionPane.showMessageDialog(null, "Numeros de palabras con vocal\n"+res);
    }
    public static void invertirString(String[] s){
        String res="";
        for (int j=0;j< s.length;j++) {
            String t;
            t = "";
            for (int contador = (s[j].length() - 1); contador >= 0; contador--) {
                t += s[j].charAt(contador);
            }
            res+=construirString("El string invertido es "+t);
        }
        JOptionPane.showMessageDialog(null, "Los strings invertidos son\n"+res);
    }
    public static void decodificacionJV(String[] s){
        String res="";
        for (int j=0;j< s.length;j++) {
            String codificado = "";
            codificado = codificacionJV(s[j]);
            int l;
            String clave = "JULIO";
            ;
            String[] codarray = {"", "", "", "", ""};
            StringBuilder stb = new StringBuilder();//30241
            int n;
            String decodificado;
            l = codificado.length() % clave.length();
            int[] pos = {2, 5, 3, 1, 4};

            StringBuilder recortado = new StringBuilder(codificado);
            char[] sobrantes = new char[l];
            if (l == 1) {
                sobrantes[0] = recortado.charAt(clave.length() * 2);
                recortado.deleteCharAt(clave.length() * 2);
            }
            if (l == 2) {
                recortado.deleteCharAt(clave.length() * 2);
                sobrantes[0] = recortado.charAt(clave.length() * 2);
                recortado.deleteCharAt(clave.length() * 5);
                sobrantes[1] = recortado.charAt(clave.length() * 5);
            }
            if (l == 3) {
                recortado.deleteCharAt(clave.length() * 2);
                sobrantes[0] = recortado.charAt(clave.length() * 2);
                recortado.deleteCharAt(clave.length() * 5);
                sobrantes[1] = recortado.charAt(clave.length() * 5);
                recortado.deleteCharAt(clave.length() * 3);
                sobrantes[2] = recortado.charAt(clave.length() * 3);
            }
            if (l == 4) {
                recortado.deleteCharAt(clave.length() * 2);
                sobrantes[0] = recortado.charAt(clave.length() * 2);
                recortado.deleteCharAt(clave.length() * 5);
                sobrantes[1] = recortado.charAt(clave.length() * 5);
                recortado.deleteCharAt(clave.length() * 3);
                sobrantes[2] = recortado.charAt(clave.length() * 3);
                recortado.deleteCharAt(clave.length());
                sobrantes[3] = recortado.charAt(clave.length());
            }
            codificado = recortado.toString();
            codarray = codificado.split("(?<=\\G.{" + clave.length() + "})");

            if (codarray.length == 1) {
                for (int m = 0; m < codarray[0].length(); m++) {
                    for (n = 0; n < codarray.length; n++) {
                        int o = pos[m] - 1;
                        stb.append(codarray[n].charAt(o));
                    }
                }
            } else {
                for (int m = 0; m < codarray[0].length(); m++) {
                    for (n = 0; n < codarray.length; n++) {
                        int o = pos[n] - 1;
                        stb.append(codarray[o].charAt(m));
                    }
                }
            }


            if (l == 1) {
                stb.insert(clave.length() * 5, sobrantes[0]);
            }
            if (l == 2) {
                stb.insert(clave.length() * 5, sobrantes[0]);
                stb.insert(clave.length() * 4, sobrantes[1]);
            }
            if (l == 3) {
                stb.insert(clave.length() * 5, sobrantes[0]);
                stb.insert(clave.length() * 4, sobrantes[1]);
                stb.insert(clave.length() * 3, sobrantes[2]);
            }
            if (l == 4) {
                stb.insert(clave.length() * 5, sobrantes[0]);
                stb.insert(clave.length() * 4, sobrantes[1]);
                stb.insert(clave.length() * 3, sobrantes[2]);
                stb.insert(clave.length() * 2, sobrantes[3]);
            }

            decodificado = stb.toString();
            decodificado = decodificado.replace('%', ' ');
            res+=construirString("El string decodificado es "+decodificado);
        }
        JOptionPane.showMessageDialog(null, "Los strings decodificados son "+res);
    }

    public static String codificacion(String texto) {
        int codigo=3; //cantidad de caracteres a recorrer
        StringBuilder cifrado = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                if ((texto.charAt(i) + codigo) > 'z') {
                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                if ((texto.charAt(i) + codigo) > 'Z') {
                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            }
        }
        return cifrado.toString();
    }

    public static void decodificacion(String[] s) {
        String res="";
        for (int j=0;j< s.length;j++) {
            int codigo = 3;
            String texto = codificacion(s[j]);
            StringBuilder cifrado = new StringBuilder();
            for (int i = 0; i < texto.length(); i++) {
                if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                    if ((texto.charAt(i) - codigo) < 'a') {
                        cifrado.append((char) (texto.charAt(i) - codigo + 26));
                    } else {
                        cifrado.append((char) (texto.charAt(i) - codigo));
                    }
                } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                    if ((texto.charAt(i) - codigo) < 'A') {
                        cifrado.append((char) (texto.charAt(i) - codigo + 26));
                    } else {
                        cifrado.append((char) (texto.charAt(i) - codigo));
                    }
                }
            }
            res+=construirString("El string decodificado es "+cifrado);
        }
        JOptionPane.showMessageDialog(null, "Los strings decodificados son "+res);
    }
    public static String construirString(String in){
        return (in+"\n");
    }
}