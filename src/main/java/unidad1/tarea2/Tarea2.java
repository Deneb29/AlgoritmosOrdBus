package unidad1.tarea2;

import javax.swing.*;
import java.util.Base64;
import java.util.StringTokenizer;


public class Tarea2 {
    public static void main(String[] args) {
        String s,i,t,codificado,decodificado,codificado2;
        int vocales,cons,digitos,caracteres,espacios,palabras,letras,l;
        char[] array;
        StringTokenizer tokens;
        byte[] bytesDecodificado;
        String clave="JULIO";
        String CODIGO="6789704086";
        int pos[]={2,5,3,1,4};
        char lts[][] =new char[20][clave.length()];


        s=guardarString("Ingrese un texto");
        do {
            t=codificado2="";
            tokens=new StringTokenizer(s," ");
            //array=new char[s.length()];
            array=s.toCharArray();
            letras=cons=vocales=digitos=caracteres=espacios=palabras=0;
            codificado=Base64.getEncoder().encodeToString(s.getBytes());
            l=0;
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
                    "16.- Encriptar método propio\n" +
                    "17.- Desencriptar método propio" +
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
                case "14":
                    codificado=s.replace(' ','%');
                    String [] codarray= {"","","","",""};
                    for (int j=0;j<20;j++) {
                        for(int k=0;k<clave.length();k++){
                            if(l<codificado.length()) {
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


                    JOptionPane.showMessageDialog(null, "El string codificado es "+codificado2);
                    break;

                case "16":
                    for(char c : s.toCharArray()) {
                        if (isVocal(c)) {
                            codificado2 += '*';
                        } else{
                            codificado2 += (char) (c + 8);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "El string codificado es "+codificado2);
            }
        }while(!i.equals("0"));
    }
    public static String guardarString(String mensaje){
        return JOptionPane.showInputDialog(mensaje,null).trim();
    }
    public static boolean isVocal(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'|| c == 'á'|| c == 'é'|| c == 'í'|| c == 'ó'|| c == 'ú'|| c == 'A'|| c == 'E'|| c == 'I'|| c == 'O'|| c == 'U'|| c == 'Á'|| c == 'É'|| c == 'Í'|| c == 'Ó'|| c == 'Ú');
    }
}