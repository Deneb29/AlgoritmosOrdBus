package unidad1.tarea21;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomNum {
    public static void main(String[] args) {
        Random random = new Random();
        int []array=new int[1000000];
        for(int i=0;i<array.length;i++){
            //array[i]= random.nextInt();
            try
            {
                String filename= "C:\\Users\\rober\\Desktop\\num.txt";
                FileWriter fw = new FileWriter(filename,true); //the true will append the new data
                fw.write((random.nextInt(9999 - (-9999)) + (-9999))+"\n");//appends the string to the file
                fw.close();
            }
            catch(IOException ioe)
            {
                System.err.println("IOException: " + ioe.getMessage());
            }
        }
        /*for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }*/
    }
}
