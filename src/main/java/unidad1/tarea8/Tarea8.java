package unidad1.tarea8;

import javax.swing.*;

public class Tarea8 {
    public static void main(String[] args) {
        String i,s;
        int num1,num2;
        int[]array=new int[10];
        do {
            i = JOptionPane.showInputDialog("Seleccione la opcion deseada:\n" +
                    "1.- Factorial\n" +
                    "2.- Fibonacci\n" +
                    "3.- Sumar digitos\n" +
                    "4.- String invertido\n" +
                    "5.- Potencia de un número\n" +
                    "6.- Suma de dos números\n" +
                    "7.- Número mayor en un arreglo\n" +
                    "0.- Salir", null);

            switch (i){
                case "1":
                    num1 = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese un número"));
                    JOptionPane.showMessageDialog(null,"El factorial de "+num1+" es:\n"+factorial(num1));
                    break;
                case "2":
                    num1 = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la posicion buscada de la sucesión de Fibonacci"));
                    JOptionPane.showMessageDialog(null,"El número en la posición "+num1+" es:\n"+fibonacci(num1));
                    break;
                case "3":
                    num1 = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese un número"));
                    JOptionPane.showMessageDialog(null,"La suma de los digitos de "+num1+" es:\n"+sumarDigitos(num1));
                    break;
                case "4":
                    s = JOptionPane.showInputDialog(null,"Ingrese un texto");
                    JOptionPane.showMessageDialog(null,"Texto original :"+s+"\n Texto invertido:"+stringInvertido(s));
                    break;
                case "5":
                    num1 = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese un número"));
                    num2 = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese una potencia"));
                    JOptionPane.showMessageDialog(null,"El número "+num1+" a la potencia "+num2+" es igual a:\n"+potencia(num1,num2));
                    break;
                case "6":
                    num1 = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese un número"));
                    num2 = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese un número"));
                    JOptionPane.showMessageDialog(null,"El número "+num1+" más el número "+num2+" es igual a:\n"+suma(num1,num2));
                    break;
                case "7":
                    JOptionPane.showMessageDialog(null,"Llene el arreglo de 10 números");
                    for (int j=0;j<array.length;j++){
                        num1 = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese un número"));
                        array[j]=num1;
                    }
                    JOptionPane.showMessageDialog(null,"El número mayor en el arreglo es:\n"+valorMaximo(array,0,0));
                    break;
            }
        }while (!i.equals("0"));
    }
    public static int fibonacci(int posicion){
        if(posicion<2){
            return posicion;
        }
        else{
            return fibonacci(posicion-1)+fibonacci(posicion-2);
        }
    }
    public static int factorial(int num){
        if(num<2 && num>-2){
            return num;
        }
        else{
            if(num >0){
                return num+factorial(num-1);
            }
            else{
                return num+factorial(num+1);
            }
        }
    }
    public static int sumarDigitos(int num){
        if(num<10 && num>-10){
            return num;
        }
        else{
            return num%10 +sumarDigitos(num/10);
        }
    }
    public static String stringInvertido(String s){
        StringBuilder sb=new StringBuilder(s);
        String s2;
        if(s.length()<2){
            return s;
        }
        else{
            sb.deleteCharAt(sb.length()-1);
            return s.charAt(s.length()-1) + stringInvertido(sb.toString());
        }
    }
    public static int potencia(int num, int potencia){
        if(potencia == 0){
            return 1;
        } else if (potencia ==1) {
            return num;
        } else{
            return num*potencia(num, potencia-1);
        }
    }
    public static int suma(int num1, int num2) {
        if(num2<1){
            return num1;
        }
        else{
            num1++;
            num2--;
            return suma(num1,num2);
        }
    }
    public static int valorMaximo(int [] a, int inicio, int valor1){
        int valor2=a[inicio];
        if(inicio==a.length-1){
            if(valor1>valor2){
                return valor1;
            }
            else {
                return valor2;
            }
        }
        else{
            if(valor1>valor2){
                return valorMaximo(a,inicio+1,valor1);
            }
            else{
                return valorMaximo(a, inicio+1, valor2);
            }
        }
    }
}
