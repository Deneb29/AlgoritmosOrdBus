package unidad1.tarea5;

import java.util.Random;

public class Tarea5 {
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
        for(int i=0;i< sopa.length;i++){
            for (int j=0;j< sopa.length;j++){
                sopa[i][j]='*';
            }
        }
        for (String s : palabras) {
            ingresarPalabra(s,sopa);
        }
        for(int i=0;i< sopa.length;i++){
            for (int j=0;j< sopa.length;j++){
                System.out.print(sopa[i][j]+"\t");
            }
            System.out.println("\n");
        }

    }

    public static void ingresarPalabra(String s, char[][] sopa) {
        Random r = new Random();
        boolean b = false;
        int x=0;
        int y=0;
        int y2=0;
        int direccion = r.nextInt(6);
        switch (direccion) {
            case 0:
                //checar si cabe el string en el array, comprobar letra por letra si se puede poner
                do {
                    x = r.nextInt(20);
                    y = y2 = r.nextInt(20);
                    if ((y + s.length()) <= 19) {
                        b = true;
                    } else {
                        b = false;
                    }
                    if (b){
                        for (int i = 0; i < s.length(); i++) {
                            if (sopa[x][i] != '*') {
                                b = true;
                            } else {
                                b = false;
                                i=s.length()+1;
                            }
                        }
                    }
                }while(!b);

                for(int i=0;i<s.length();i++){
                    if(sopa[x][y]=='*'){
                        sopa[x][y]=s.charAt(i);
                    }
                    y++;
                }
                break;
            case 1:
                b=false;
                //checar si cabe el string en el array, comprobar letra por letra si se puede poner
                do {
                    x = r.nextInt(20);
                    y = r.nextInt(20);
                    if ((y - s.length()) > 0) {
                        b = true;
                    }
                    else{
                        b=false;
                    }
                    if (b) {
                        for (int i = 0; i < s.length(); i++) {
                            if (sopa[x][i] =='*') {
                                b = true;
                            } else {
                                b = false;
                                i=s.length()+1;
                            }
                        }
                    }
                }while(!b);

                for(int i=0;i<s.length();i++){
                    if(sopa[x][y]=='*'){
                        sopa[x][y]=s.charAt(i);
                    }
                    y--;
                }
                break;

            case 2:
                b=false;
                //checar si cabe el string en el array, comprobar letra por letra si se puede poner
                do {
                    x = r.nextInt(20);
                    y = y2 = r.nextInt(20);
                    if ((x + s.length()) <= 19) {
                        b = true;
                    }
                    else{
                        b=false;
                    }
                    if (b) {
                        for (int i = 0; i < s.length(); i++) {
                            if (sopa[i][x] =='*') {
                                b = true;
                            } else {
                                b = false;
                                i=s.length()+1;
                            }
                        }
                    }
                }while(!b);

                for(int i=0;i<s.length();i++){
                    if(sopa[x][y]=='*'){
                        sopa[x][y]=s.charAt(i);
                    }
                    x++;
                }
                break;

            case 3:
                b=false;
                do {
                    x = r.nextInt(20);
                    y = r.nextInt(20);
                    if ((x - s.length()) > 0) {
                        b = true;
                    }
                    else{
                        b=false;
                    }
                    if (b) {
                        for (int i = 0; i < s.length(); i++) {
                            if (sopa[i][x] =='*') {
                                b = true;
                            } else {
                                b = false;
                                i=s.length()+1;
                            }
                        }
                    }
                }while(!b);

                for(int i=0;i<s.length();i++){
                    if(sopa[x][y]=='*'){
                        sopa[x][y]=s.charAt(i);
                    }
                    x--;
                }
                break;
            case 4:
                b=false;
                //checar si cabe el string en el array, comprobar letra por letra si se puede poner
                do {
                    x = r.nextInt(20);
                    y = y2 = r.nextInt(20);
                    if ((y + s.length()) <= 19 && (x + s.length()) <= 19) {
                        b = true;
                    }
                    else{
                        b=false;
                    }
                    if (b) {
                        for (int i = 0; i < s.length(); i++) {
                            if (sopa[x + i][i] =='*') {
                                b = true;
                            } else {
                                b = false;
                                i=s.length()+1;
                            }
                        }
                    }
                }while(!b);

                for(int i=0;i<s.length();i++){
                    if(sopa[x][y]=='*'){
                        sopa[x][y]=s.charAt(i);
                    }
                    y++;
                    x++;
                }
                break;
            case 5:
                b=false;
                //checar si cabe el string en el array, comprobar letra por letra si se puede poner
                do {
                    x = r.nextInt(20);
                    y = r.nextInt(20);
                    if ((y - s.length()) > 0 && (x - s.length()) >0) {
                        b = true;
                    }
                    else{
                        b=false;
                    }
                    if (b) {
                        for (int i = 0; i < s.length(); i++) {
                            if (sopa[x - i][i] =='*') {
                                b = true;
                            } else {
                                b = false;
                                i=s.length()+1;
                            }
                        }
                    }
                }while(!b);

                for(int i=0;i<s.length();i++){
                    if(sopa[x][y]=='*'){
                        sopa[x][y]=s.charAt(i);
                    }
                    y--;
                    x--;
                }
                break;
        }
    }
}
