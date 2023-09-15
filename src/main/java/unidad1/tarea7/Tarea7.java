package unidad1.tarea7;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Tarea7 {
    public static void main(String[] args) {
        String i,s,correcto;
        s=JOptionPane.showInputDialog("Ingrese un texto:\n");
        do {
            i = JOptionPane.showInputDialog("Seleccione la opcion deseada:\n" +
                    "Texto: "+s+"\n" +
                    "1.- Leer otro texto\n" +
                    "2.- Adivinar\n" +
                    "3.- Palabras más comunes\n" +
                    "0.- Salir", null);

            switch (i){
                case "1":
                    s=JOptionPane.showInputDialog("Ingrese un texto:\n");
                    break;
                case "2":
                    String res="";
                    String opcion="";
                    String p1="";
                    String p2="";
                    String p3="";
                    do{
                        correcto = JOptionPane.showInputDialog("Ingrese un texto:", null);
                        StringTokenizer tokens;
                        if(!correcto.equals("")){
                            tokens=new StringTokenizer(leerArchivo(3,correcto));
                        }
                        else {
                            tokens=new StringTokenizer("");
                        }
                        if(tokens.hasMoreElements()){
                            p1= tokens.nextToken();
                        }
                        if(tokens.hasMoreElements()){
                            p2= tokens.nextToken();
                        }
                        if(tokens.hasMoreElements()){
                            p3= tokens.nextToken();
                        }
                        opcion = JOptionPane.showInputDialog("Elija la opcion correcta:\n"+
                                "1.- "+p1+"\n"+
                                "2.- "+p2+"\n"+
                                "3.- "+p3+"\n"+
                                "O elija entre las siguientes opciones: \n"+
                                "4.- Agregar mi palabra: "+correcto+"\n"+
                                "5.- Intentar con una palabra diferente"+"\n"+
                                "6.- Imprimir texto"+"\n"+
                                "0.- Salir", null);
                        if (opcion.equals("1")) {
                            res+=p1+" ";
                            JOptionPane.showMessageDialog(null, "Texto hasta ahora: \n"+res);
                        }
                        if (opcion.equals("2")) {
                            res+=p2+" ";
                            JOptionPane.showMessageDialog(null, "Texto hasta ahora: \n"+res);
                        }
                        if (opcion.equals("3")) {
                            res+=p3+" ";
                            JOptionPane.showMessageDialog(null, "Texto hasta ahora: \n"+res);
                        }
                        if (opcion.equals("4")) {
                            res+=correcto+" ";
                            JOptionPane.showMessageDialog(null, "Texto hasta ahora: \n"+res);
                        }
                        if (opcion.equals("6")) {
                            JOptionPane.showMessageDialog(null, "Texto hasta ahora: \n"+res);
                        }
                        p1=p2=p3="";
                    }while (!opcion.equals("0"));
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null,"Coincidencias más comunes:\n"+leerArchivo(5,s));
                    break;
            }
        }while (!i.equals("0"));
    }
    public static String leerArchivo(int veces,String s){
        String nombreFichero = "D:\\Proyectos\\AlgoritmosOrdBus\\src\\main\\java\\unidad1\\tarea7\\palabras_comunes.txt";
        BufferedReader br = null;
        String res="";
        int contador=0;
        try {
            br = new BufferedReader(new FileReader(nombreFichero));
            String texto = br.readLine();
            while(texto != null) {
                if(texto.startsWith(s) && contador<veces){
                    res+=texto+" ";
                    contador++;
                }
                texto = br.readLine();
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("Error: Fichero no encontrado");
            ex.printStackTrace();
        }
        catch(Exception ex) {
            System.out.println("Error de lectura del fichero");
            ex.printStackTrace();
        }
        finally {
            try {
                if(br != null) {
                    br.close();
                }
            }
            catch (Exception ex) {
                System.out.println("Error al cerrar el fichero");
                ex.printStackTrace();
            }
        }
        return res;
    }
}
