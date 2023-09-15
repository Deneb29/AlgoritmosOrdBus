package unidad1.tarea7;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

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
                    String k;
                        correcto = JOptionPane.showInputDialog("Primera coincidencia: \n" +
                                leerArchivo(1,s)+
                                "¿Es correcta? \n" +
                                "1.- Si \n" +
                                "2.- No \n", null);
                        if (correcto.equals("1")) {
                            JOptionPane.showMessageDialog(null, "Palabra correcta: "+leerArchivo(1,s));
                        }
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
                    res+=texto+"\n";
                    contador++;
                }
                texto = br.readLine();
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("Error: Fichero no encontrado");
            ex.printStackTrace();
        }
// Captura de cualquier otra excepción
        catch(Exception ex) {
            System.out.println("Error de lectura del fichero");
            ex.printStackTrace();
        }
// Asegurar el cierre del fichero en cualquier caso
        finally {
            try {
                // Cerrar el fichero si se ha podido abrir
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
