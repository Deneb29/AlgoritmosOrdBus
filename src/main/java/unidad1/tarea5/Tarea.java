package unidad1.tarea5;

import java.util.Random;
import java.util.Scanner;

public class Tarea {
    public static void main(String[] args) {
        String[] palabras = {
                "PERRO",
                "GATO",
                "PEZ",
                "PAJARO",
                "CONEJO",
                "ELEFANTE",
                "LEON",
                "TIGRE",
                "OSO",
                "JIRAFA"
        };
        char [][] sopa=new char[20][20];
        Random r=new Random();
        Palabra [] p=new Palabra[palabras.length];
        boolean finalizado=false;

        for(int i=0;i< sopa.length;i++){
            for (int j=0;j< sopa.length;j++){
                sopa[i][j]=(char)(r.nextInt(90 - 65) + 65);
            }
        }

        ingresarPalabra(palabras[0],sopa,0,1,5,1,9, p, 0);
        ingresarPalabra(palabras[1],sopa,2,15,12,18,12, p, 1);
        ingresarPalabra(palabras[2],sopa,4,16,2,18,4, p, 2);
        ingresarPalabra(palabras[3],sopa,1,3,18,3,13, p, 3);
        ingresarPalabra(palabras[4],sopa,3,17,19,12,19, p, 4);
        ingresarPalabra(palabras[5],sopa,5,13,15,6,8, p, 5);
        ingresarPalabra(palabras[6],sopa,0,6,0,6,3, p, 6);
        ingresarPalabra(palabras[7],sopa,2,7,17,11,17, p, 7);
        ingresarPalabra(palabras[8],sopa,1,17,7,17,10, p, 8);
        ingresarPalabra(palabras[9],sopa,4,7,3,12,8, p, 9);

        do{
            input(sopa,p);
            for (Palabra pal : p) {
                if(pal.isEncontrado()){
                    finalizado=true;
                }
                else{
                    finalizado=false;
                    break;
                }
            }
        }while (!finalizado);
        System.out.println("Felicidades, ha completado la sopa de letras");

    }

    public static void ingresarPalabra(String s, char[][] sopa, int direccion, int x1, int y1, int x2, int y2, Palabra[] p, int indice) {
        switch (direccion) {
            case 0:
                for(int i=0;i<s.length();i++){
                    sopa[x1][y1]=s.charAt(i);
                    y1++;
                }
                p[indice]=new Palabra(s, x1, y1-s.length(), x2,y2);
                break;
            case 1:
                for(int i=0;i<s.length();i++){
                    sopa[x1][y1]=s.charAt(i);
                    y1--;
                }
                p[indice]=new Palabra(s, x1, y1+s.length(), x2,y2);
                break;

            case 2:
                for(int i=0;i<s.length();i++){
                    sopa[x1][y1]=s.charAt(i);
                    x1++;
                }
                p[indice]=new Palabra(s, x1-s.length(), y1, x2,y2);
                break;

            case 3:
                for(int i=0;i<s.length();i++){
                    sopa[x1][y1]=s.charAt(i);
                    x1--;
                }
                p[indice]=new Palabra(s, x1+s.length(), y1, x2,y2);
                break;
            case 4:
                for(int i=0;i<s.length();i++){
                    sopa[x1][y1]=s.charAt(i);
                    y1++;
                    x1++;
                }
                p[indice]=new Palabra(s, x1-s.length(), y1-s.length(), x2,y2);
                break;
            case 5:
                for(int i=0;i<s.length();i++){
                    sopa[x1][y1]=s.charAt(i);
                    y1--;
                    x1--;
                }
                p[indice]=new Palabra(s, x1+s.length(), y1+s.length(), x2,y2);
                break;
        }
    }
    public static void imprimirSopa(char[][] sopa){
        System.out.print("\t");
        for(int i=0;i< sopa.length;i++){
            System.out.print(i+"\t");
        }
        System.out.println("");
        for(int i=0;i< sopa.length;i++){
            System.out.print(i+"\t");
            for (int j=0;j< sopa.length;j++){
                System.out.print(sopa[i][j]+"\t");
            }
            System.out.println("\n");
        }
    }

    public static void input(char[][] sopa, Palabra palabras[]){
        Scanner sc=new Scanner(System.in);
        boolean b=false;
        int x1,y1,x2,y2;
        imprimirSopa(sopa);
        System.out.println("Palabras a encontrar");
        for (Palabra p : palabras) {
            if(!p.isEncontrado()) {
                System.out.print(p.getTexto() + "\t");
            }
        }
        System.out.println("\nIngrese 50 para salir");
        System.out.println("\nIngrese el indice vertical del inicio de la palabra");
        x1=sc.nextInt();
        if(x1==50){
            System.exit(0);
        }
        System.out.println("\nIngrese el indice horizontal del inicio de la palabra");
        y1=sc.nextInt();
        if(y1==50){
            System.exit(0);
        }
        System.out.println("\nIngrese el indice vertical del final de la palabra");
        x2=sc.nextInt();
        if(x2==50){
            System.exit(0);
        }
        System.out.println("\nIngrese el indice horizontal del final de la palabra");
        y2=sc.nextInt();
        if(y2==50){
            System.exit(0);
        }
        for (Palabra p : palabras) {
            if(x1 == p.getX1() && y1 == p.getY1()&& x2 == p.getX2() && y2 == p.getY2()){
                p.setEncontrado(true);
                System.out.println("Palabra encontrada");
                System.out.println("=============================================================");
            }
        }
    }
}
