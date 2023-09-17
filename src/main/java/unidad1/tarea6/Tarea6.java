package unidad1.tarea6;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;
import java.util.StringTokenizer;

public class Tarea6 {
    public static void main(String[] args) {
        String i, s;
        int num;
        int[] array = new int[10];
        do {
            i = JOptionPane.showInputDialog("Seleccione la opcion deseada:\n" +
                    "1.- Número a texto\n" +
                    "2.- Reproducir frase\n" +
                    "0.- Salir", null);

            switch (i) {
                case "1":
                    num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número:\n"));
                    JOptionPane.showMessageDialog(null,numeroATexto(num));
                    break;
                case "2":
                    s="jugar es solo otra version de trabajar";
                    JOptionPane.showMessageDialog(null,s);
                    StringTokenizer st=new StringTokenizer(s);
                    while(st.hasMoreTokens()) {
                        reproducirAudio(st.nextToken());
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
            }
        } while (!i.equals("0"));
    }

    public static String numeroATexto(int num) {
        String res="";
        if(num<10){
            res=unidades(num);
        }
        else if(num<100){
            res=decenas(num);
        }
        else if(num<1000){
            res=centenas(num);
        }
        else if(num<10000){
            res=millares(num);
        }
        else if(num<100000){
            res=decenasDeMillares(num);
        }
        else if(num<1000000){
            res=centenasDeMillares(num);
        }
        else if(num==1000000){
            res="un millon";
        }
        else {
            res="Número no válido";
        }
        StringTokenizer st=new StringTokenizer(res);
        while(st.hasMoreTokens()) {
            reproducirAudio(st.nextToken());
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return res;
    }
    public static String unidades(int num){
        String res="";
        switch (num){
            case 0: res="cero";break;
            case 1: res="uno";break;
            case 2: res="dos";break;
            case 3: res="tres";break;
            case 4: res="cuatro";break;
            case 5: res="cinco";break;
            case 6: res="seis";break;
            case 7: res="siete";break;
            case 8: res="ocho";break;
            case 9: res="nueve";break;
        }
        return res;
    }
    public static String decenas(int num){
        String res="";
        int unidades=num%10;
        int decenas=num/10;
        switch (decenas){
            case 1:
                if(unidades<1){
                    res="diez";
                }
                else{
                    switch (unidades){
                        case 1: res="once";break;
                        case 2: res="doce";break;
                        case 3: res="trece";break;
                        case 4: res="catorce";break;
                        case 5: res="quince";break;
                        default:
                            res="dieci"+unidades(unidades);
                            break;
                    }
                }
                break;
            case 2:
                if(unidades<1){
                    res="veinte";
                }
                else{
                    res="veinti"+unidades(unidades);
                }
                break;
            case 3:
                if(unidades<1){
                    res="treinta";
                }
                else{
                    res="treinta y "+unidades(unidades);
                }
                break;
            case 4:
                if(unidades<1){
                    res="cuarenta";
                }
                else{
                    res="cuarenta y "+unidades(unidades);
                }
                break;
            case 5:
                if(unidades<1){
                    res="cincuenta";
                }
                else{
                    res="cincuenta y "+unidades(unidades);
                }
                break;
            case 6:
                if(unidades<1){
                    res="sesenta";
                }
                else{
                    res="sesenta y "+unidades(unidades);
                }
                break;
            case 7:
                if(unidades<1){
                    res="setenta";
                }
                else{
                    res="setenta y "+unidades(unidades);
                }
                break;
            case 8:
                if(unidades<1){
                    res="ochenta";
                }
                else{
                    res="ochenta y "+unidades(unidades);
                }
                break;
            case 9:
                if(unidades<1){
                    res="noventa";
                }
                else{
                    res="noventa y "+unidades(unidades);
                }
                break;

        }
        return res;
    }
    public static String centenas(int num){
        String res="";
        int unidades=num%10;
        int decenas=num%100;
        int centenas=num/100;
        switch (centenas){
            case 1:
                if(unidades<1 && decenas<1){
                    res="cien";
                }
                else{
                    res="ciento "+ decenas(decenas);
                }
                break;
            case 2: res="doscientos "+ decenas(decenas);break;
            case 3: res="trescientos "+ decenas(decenas);break;
            case 4: res="cuatrocientos "+ decenas(decenas);break;
            case 5: res="quinientos "+ decenas(decenas);break;
            case 6: res="seiscientos "+ decenas(decenas);break;
            case 7: res="setecientos "+ decenas(decenas);break;
            case 8: res="ochocientos "+ decenas(decenas);break;
            case 9: res="novecientos "+ decenas(decenas);break;

        }
        return res;
    }
    public static String millares(int num){
        String res="";
        int centenas=num%1000;
        int millares=num/1000;
        if(millares<2){
            res="mil "+ centenas(centenas);
        }
        else{
            res=unidades(millares)+" mil "+centenas(centenas);
        }
        return res;
    }
    public static String decenasDeMillares(int num){
        String res="";
        int centenas=num%1000;
        int dmillares=num/1000;
        res=decenas(dmillares)+" mil "+centenas(centenas);
        return res;
    }
    public static String centenasDeMillares(int num){
        String res="";
        int centenas=num%1000;
        int dmillares=num/1000;
        res=centenas(dmillares)+" mil "+centenas(centenas);
        return res;
    }
    public static void reproducirAudio(String num){
        try {
            String path="D:\\numeros\\"+num+".wav";
            AudioInputStream aui= AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
            try {
                Clip clip=AudioSystem.getClip();
                clip.open(aui);
                clip.start();
            }
            catch (Exception e){
                System.out.println("Archivo no encontrado");
            }
        }
        catch (Exception e){
            System.out.println("Archivo no encontrado");
        }
    }
}
