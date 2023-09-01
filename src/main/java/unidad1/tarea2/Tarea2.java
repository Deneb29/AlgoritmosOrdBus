package unidad1.tarea2;

import javax.swing.*;
import java.util.StringTokenizer;


public class Tarea2 {
    public static void main(String[] args) {
        String s,i;

        s=guardarString("Ingrese un texto");
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
                    s=guardarString("Ingrese un texto");
                    break;
                case "2":
                    getLongitud(s);
                    break;
                case "3":
                    getLetras(s);
                    break;
                case "4":
                    getDigitos(s);
                    break;
                case "5":
                    getEspacios(s);
                    break;
                case "6":
                    getCaracteres(s);
                    break;
                case "7":
                    getPalabras(s);
                    break;
                case "8":
                    aMayusculas(s);
                    break;
                case "9":
                    aMinusculas(s);
                    break;
                case "10":
                    iniciaVocal(s);
                    break;
                case "11":
                    invertirString(s);
                    break;
                case "12":
                    JOptionPane.showMessageDialog(null, "El string codificado es "+codificacion(s));
                    break;
                case "13":
                    decodificacion(s);
                    break;
                case "14":
                    JOptionPane.showMessageDialog(null, "El string codificado es "+codificacionJV(s));
                    break;
                case "15":
                    decodificacionJV(s);
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
    public static void getLongitud(String s){
        JOptionPane.showMessageDialog(null, "La logitud del string es "+s.length());
    }
    public static String codificacionJV(String s){
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
    public static void getLetras(String s){
        int vocales,cons,digitos,letras;
        char[] array;
        array=s.toCharArray();
        letras=cons=vocales=digitos=0;
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

    }
    public static void getDigitos(String s){
        char[] array;
        int digitos;
        array=s.toCharArray();
        digitos=0;

        for (char c:
                array) {
            if(Character.isDigit(c)){
                digitos++;
            }
        }
        JOptionPane.showMessageDialog(null, "El string "+s+" tiene "+digitos+" digitos");
    }
    public static void getEspacios(String s){
        char[] array;
        int espacios;
        array=s.toCharArray();
        espacios=0;
        for (char c:
                array) {
            if(Character.isWhitespace(c)){
                espacios++;
            }
        }
        JOptionPane.showMessageDialog(null, "El string "+s+" tiene "+espacios+" espacios en blanco");
    }
    public static void getCaracteres(String s){
        char[] array;
        int caracteres;
        array=s.toCharArray();
        caracteres=0;
        for (char c:
                array) {
            if(!Character.isLetterOrDigit(c)&&!Character.isWhitespace(c)){
                caracteres++;
            }
        }
        JOptionPane.showMessageDialog(null, "El string "+s+" tiene "+caracteres+" caracteres especiales");
    }
    public static void getPalabras(String s){
        StringTokenizer tokens;
        tokens=new StringTokenizer(s," ");
        JOptionPane.showMessageDialog(null, "El string "+s+" tiene "+tokens.countTokens()+" palabras");
    }
    public static void aMayusculas(String s){
        JOptionPane.showMessageDialog(null,"El texto en mayusculas es "+s.toUpperCase());
    }
    public static void aMinusculas(String s){
        JOptionPane.showMessageDialog(null,"El texto en minusculas es "+s.toLowerCase());
    }
    public static void iniciaVocal(String s){
        StringTokenizer tokens;
        int palabras;
        tokens=new StringTokenizer(s," ");
        palabras=0;

        while (tokens.hasMoreElements()) {
            if(isVocal(tokens.nextToken().toCharArray()[0])){
                palabras++;
            }
        }
        JOptionPane.showMessageDialog(null, "El string "+s+" tiene "+palabras+" palabras que comienzan con vocal");
    }
    public static void invertirString(String s){
        String t;
        t="";
        for (int contador=(s.length()-1);contador>=0;contador--) {
            t+=s.charAt(contador);
        }
        JOptionPane.showMessageDialog(null, "El string "+s+" invertido es "+t);
    }
    public static void decodificacionJV(String s){
        String codificado ="";
        codificado=codificacionJV(s);
        int l;
        String clave="JULIO";;
        String [] codarray= {"","","","",""};
        StringBuilder stb=new StringBuilder();//30241
        int n;
        String decodificado=stb.toString();
        l=codificado.length()%clave.length();

        StringBuilder recortado=new StringBuilder(codificado);
        char [] sobrantes=new char[l];
        if(l==1){
            sobrantes[0]= recortado.charAt(clave.length()*2);
            recortado.deleteCharAt(clave.length()*2);
        }
        if(l==2){
            recortado.deleteCharAt(clave.length()*2);
            sobrantes[0]= recortado.charAt(clave.length()*2);
            recortado.deleteCharAt(clave.length()*5);
            sobrantes[1]= recortado.charAt(clave.length()*5);
        }
        if (l==3){
            recortado.deleteCharAt(clave.length()*2);
            sobrantes[0]= recortado.charAt(clave.length()*2);
            recortado.deleteCharAt(clave.length()*5);
            sobrantes[1]= recortado.charAt(clave.length()*5);
            recortado.deleteCharAt(clave.length()*3);
            sobrantes[2]= recortado.charAt(clave.length()*3);
        }
        if(l==4){
            recortado.deleteCharAt(clave.length()*2);
            sobrantes[0]= recortado.charAt(clave.length()*2);
            recortado.deleteCharAt(clave.length()*5);
            sobrantes[1]= recortado.charAt(clave.length()*5);
            recortado.deleteCharAt(clave.length()*3);
            sobrantes[2]= recortado.charAt(clave.length()*3);
            recortado.deleteCharAt(clave.length());
            sobrantes[3]= recortado.charAt(clave.length());
        }
        codificado=recortado.toString();
        codarray = codificado.split("(?<=\\G.{" + clave.length() + "})");

                for (int m=0;m<codarray[4].length();m++){
                    n=1;
                    stb.append(codarray[n].charAt(m));
                    n=4;
                    stb.append(codarray[n].charAt(m));
                    n=2;
                    stb.append(codarray[n].charAt(m));
                    n=0;
                    stb.append(codarray[n].charAt(m));
                    n=3;
                    stb.append(codarray[n].charAt(m));
                }
                if(l==1){
                    stb.insert(clave.length()*5,sobrantes[0]);
                }
                if(l==2){
                    stb.insert(clave.length()*5,sobrantes[0]);
                    stb.insert(clave.length()*4,sobrantes[1]);
                }
                if (l==3){
                    stb.insert(clave.length()*5,sobrantes[0]);
                    stb.insert(clave.length()*4,sobrantes[1]);
                    stb.insert(clave.length()*3,sobrantes[2]);
                }
                if(l==4){
                    stb.insert(clave.length()*5,sobrantes[0]);
                    stb.insert(clave.length()*4,sobrantes[1]);
                    stb.insert(clave.length()*3,sobrantes[2]);
                    stb.insert(clave.length()*2,sobrantes[3]);
                }

        decodificado=stb.toString();
        decodificado=decodificado.replace('%',' ');
        JOptionPane.showMessageDialog(null, "El string decodificado es "+decodificado);
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
    
    public static void decodificacion(String s) {
        int codigo=3;
        String texto=codificacion(s);
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
        JOptionPane.showMessageDialog(null, "El string decodificado es "+cifrado);
    }
}