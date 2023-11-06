package unidad1.tarea21;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Tarea21 {
    public static void main(String[] args) throws IOException {
        String i;
        //int[]array= {54,76,32,98,23,65,34,83,92,12};
        int[]aux;
        long startTime,endTime,totalTime;
        List<String> lines = Files.readAllLines(Paths.get("D:\\Proyectos\\AlgoritmosOrdBus\\src\\main\\java\\unidad1\\tarea21\\numeros.txt"));
        int[]array=new int[100000];
        Object[] B= lines.toArray();
        for(int j=0;j<array.length;j++){
            array[j]=Integer.parseInt(B[j].toString());
        }
        do {
            int[]stats;
            i = JOptionPane.showInputDialog("Seleccione la opcion deseada:\n" +
                    "1.- Inserción directa\n" +
                    "2.- Selección\n" +
                    "3.- Burbuja\n" +
                    "4.- Quick sort\n" +
                    "5.- Bin sort\n" +
                    "6.- Radix\n" +
                    "7.- Merge\n" +
                    "8.- Shell\n" +
                    "9.- Arbol binario\n" +
                    "10.- Heap\n" +
                    "11.- Gnome\n" +
                    "0.- Salir", null);

            switch (i){
                case "1":
                    startTime=System.nanoTime();
                    stats=insercion(array);
                    endTime=System.nanoTime();
                    totalTime = endTime - startTime;
                    imprimir("Inserción",array,stats[0],stats[1],totalTime);

                    break;
                case "2":
                    startTime=System.nanoTime();
                    stats=seleccion(array);
                    endTime=System.nanoTime();
                    totalTime = endTime - startTime;
                    imprimir("Selección",array,stats[0],stats[1],totalTime);
                    break;
                case "3":
                    startTime=System.nanoTime();
                    stats=bubble(array);
                    endTime=System.nanoTime();
                    totalTime = endTime - startTime;
                    imprimir("Burbuja",array,stats[0],stats[1],totalTime);
                    break;
                case "4":
                    startTime=System.nanoTime();
                    stats=quicksort(array,0,array.length-1);
                    endTime=System.nanoTime();
                    totalTime = endTime - startTime;
                    imprimir("Quick sort",array,stats[0],stats[1],totalTime);
                    break;

                case "5":
                    startTime=System.nanoTime();
                    stats=bucketSort(array, array.length);
                    endTime=System.nanoTime();
                    totalTime = endTime - startTime;
                    imprimir("Bin sort",array,stats[0],stats[1],totalTime);
                    break;
                case "6":
                    startTime=System.nanoTime();
                    stats=radixSort(array);
                    endTime=System.nanoTime();
                    totalTime = endTime - startTime;
                    imprimir("Radix",array,stats[0],stats[1],totalTime);
                    break;
                case "7":
                    startTime=System.nanoTime();
                    stats=mergeSort(array, array.length);
                    endTime=System.nanoTime();
                    totalTime = endTime - startTime;
                    imprimir("Merge",array,stats[0],stats[1],totalTime);
                    break;
                case "8":
                    startTime=System.nanoTime();
                    stats=shell(array);
                    endTime=System.nanoTime();
                    totalTime = endTime - startTime;
                    imprimir("Shell",array,stats[0],stats[1],totalTime);
                    break;
                case "9":
                    startTime=System.nanoTime();
                    stats=tree(array);
                    endTime=System.nanoTime();
                    totalTime = endTime - startTime;
                    imprimir("Tree",array,stats[0],stats[1],totalTime);
                    break;
                case "10":
                    startTime=System.nanoTime();
                    stats=heapSort(array);
                    endTime=System.nanoTime();
                    totalTime = endTime - startTime;
                    imprimir("Heap",array,stats[0],stats[1],totalTime);
                    break;
                case "11":
                    startTime=System.nanoTime();
                    stats=gnomeSort(array, array.length);
                    endTime=System.nanoTime();
                    totalTime = endTime - startTime;
                    imprimir("Gnome",array,stats[0],stats[1],totalTime);
                    break;
            }
        }while (!i.equals("0"));
    }
    public static void imprimir(String nombre,int[]A, int comp, int mov,long time){
        JOptionPane.showMessageDialog(null,nombre+"\n"+
                Arrays.toString(A) +
                "\nComparaciones: "+comp+
                "\nMovimientos: "+mov+
                "\nTiempo de ejecución: "+time+" nanosegundos");
    }
    public static int[] insercion(int[] A){
        int comp=0;
        int mov=0;
        int aux;
        for (int i = 1; i < A.length; i++){ // desde el segundo elemento hasta
            aux = A[i]; // el final, guardamos el elemento y
            int j = i - 1; // empezamos a comprobar con el anterior
            while ((j >= 0) && (aux < A[j])){ // mientras queden posiciones y el
                // valor de aux sea menor que los
                A[j + 1] = A[j];       // de la izquierda, se desplaza a
                j--;                   // la derecha
                mov++;
                comp++;
            }
            A[j + 1] = aux; // colocamos aux en su sitio
            mov++;
        }
        return new int[]{comp,mov};
    }

    public static int[] seleccion(int[] A){
        int comp=0;
        int mov=0;
        for (int i = 0; i  < A.length - 1; i++) {
            int men = i;
            for (int j = i+1; j < A.length; j++) {
                if (A[j] < A[men]) {
                    men = j;
                }
                comp ++;

            }
            int aux = A[i];
            A[i] = A[men];
            A[men] = aux;
            mov+=2;
        }
        return new int[]{comp,mov};
    }
    public static int[] bubble(int[] A){
        int comp=0;
        int mov=0;
        for (int i = 0; i < A.length; i++) {
            // Aquí "j" se detiene antes de llegar
            // a length - 1 porque dentro del for, accedemos
            // al siguiente elemento con el índice actual + 1
            for (int j = 0; j < A.length - 1; j++) {
                int elementoActual = A[j];
                int elementoSiguiente = A[j + 1];
                comp++;
                if (elementoActual > elementoSiguiente) {
                    // Intercambiar
                    A[j] = elementoSiguiente;
                    A[j + 1] = elementoActual;
                    mov+=2;
                }
            }
        }
        return new int[]{comp,mov};
    }
    public static int[] quicksort(int A[], int izq, int der) {
        int comp=0;
        int mov=0;
        int pivote=A[izq]; // tomamos primer elemento como pivote
        int i=izq;         // i realiza la búsqueda de izquierda a derecha
        int j=der;         // j realiza la búsqueda de derecha a izquierda
        int aux;
        int[]x;

        while(i < j){                          // mientras no se crucen las búsquedas
            while(A[i] <= pivote && i < j) i++; // busca elemento mayor que pivote
            comp++;
            while(A[j] > pivote) j--;           // busca elemento menor que pivote
            comp++;
            if (i < j) {                        // si no se han cruzado
                aux= A[i];                      // los intercambia
                A[i]=A[j];
                mov++;
                A[j]=aux;
                mov++;
            }
        }

        A[izq]=A[j];      // se coloca el pivote en su lugar de forma que tendremos
        mov++;
        A[j]=pivote;      // los menores a su izquierda y los mayores a su derecha
        mov++;

        if(izq < j-1) {
            x = quicksort(A, izq, j - 1);          // ordenamos subarray izquierdo
            comp += x[0];
            mov += x[1];
        }
        if(j+1 < der) {
            x=quicksort(A, j + 1, der);          // ordenamos subarray derecho
            comp += x[0];
            mov += x[1];
        }

        return new int[]{comp,mov};
    }
    public static int[] bucketSort(int [] A, int n) {
        int comp=0;
        int mov=0;

        int[][]B=new int[n][];
        for(int i=0;i<n;i++){
            mov++;
            B[i]=new int[n];
        }

        for (int i = 0; i < n; i++) {
            int idx = A[i] / n;
            B[idx][i]=A[i];
            mov++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(B[i][j]==0) {
                    B[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int[]C=insercion(B[i]);
            comp+=C[0];
            mov+=C[1];
        }
        int k=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(B[i][j]!=Integer.MAX_VALUE) {
                    mov++;
                    A[k] = B[i][j];
                    k++;
                }
            }
        }
        return new int[]{comp,mov};
    }
    public static int[] radixSort(int[] arr){
        int comp=0;
        int mov=0;
        if(arr.length == 0)
            return new int[]{comp,mov};

        int[][] np = new int[arr.length][2];
        int[] q = new int[0x100];
        int i,j,k,l,f = 0;

        for(k=0;k<4;k++){
            for(i=0;i<(np.length-1);i++) {
                np[i][1] = i + 1;
            }
            np[i][1] = -1;

            for(i=0;i<q.length;i++) {
                q[i] = -1;
            }

            for(f=i=0;i<arr.length;i++){
                j = ((0xFF<<(k<<3))&arr[i])>>(k<<3);
                comp++;
                if(q[j] == -1){
                    l = q[j] = f;
                }

                else{
                    l = q[j];
                    while(np[l][1] != -1){
                        l = np[l][1];
                    }
                    mov++;
                    np[l][1] = f;
                    l = np[l][1];
                }
                f = np[f][1];
                np[l][0] = arr[i];
                np[l][1] = -1;
                mov+=2;
            }

            for(l=q[i=j=0];i<0x100;i++) {
                for (l = q[i]; l != -1; l = np[l][1]) {
                    mov++;
                    arr[j++] = np[l][0];
                }
            }
        }
        return new int[]{comp,mov};
    }
    public static int[] mergeSort(int[] a, int n) {
        int comp=0;
        int mov=0;
        if (n < 2) {
            return new int[]{comp,mov};
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            mov++;
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            mov++;
            r[i - mid] = a[i];
        }
        int[]left=mergeSort(l, mid);
        int[]right=mergeSort(r, n - mid);

        int[]m=merge(a, l, r, mid, n - mid);
        comp=comp+left[0]+right[0]+m[0];
        mov=mov+left[1]+right[1]+m[1];
        return new int[]{comp,mov};
    }
    public static int[] merge(int[] a, int[] l, int[] r, int left, int right) {
        int comp=0;
        int mov=0;
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            comp++;
            if (l[i] <= r[j]) {
                mov++;
                a[k++] = l[i++];
            }
            else {
                mov++;
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            mov++;
            a[k++] = l[i++];
        }
        while (j < right) {
            mov++;
            a[k++] = r[j++];
        }
        return new int[]{comp,mov};
    }

    public static int[] shell(int[] arrayToSort) {
        int comp=0;
        int mov=0;
        int n = arrayToSort.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int key = arrayToSort[i];
                int j = i;
                while (j >= gap && arrayToSort[j - gap] > key) {
                    comp++;mov++;
                    arrayToSort[j] = arrayToSort[j - gap];
                    j -= gap;
                }
                mov++;
                arrayToSort[j] = key;
            }
        }
        return new int[]{comp,mov};
    }
    public static int[] tree(int[]A){
        int comp=0;
        int mov=0;
        TreeSet<Integer> arbol = new TreeSet<>();
        for(int i:A){
            mov++;
            arbol.add(i);
        }
        Object[] B=arbol.toArray();
        for(int i=0;i<B.length;i++){
            mov++;
            A[i]=Integer.parseInt(B[i].toString());
        }
        return new int[]{comp,mov};
    }
    public static int[] heapSort(int[] arr) {
        int comp=0;
        int mov=0;
        int n = arr.length;
        int[]h;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            h=heapify(arr, n, i);
            comp+=h[0];
            mov+=h[1];
        }

        // Heap sort
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            mov+=2;

            // Heapify root element
            h=heapify(arr, i, 0);
            comp+=h[0];
            mov+=h[1];
        }
        return new int[]{comp,mov};
    }

    public static int[] heapify(int[] arr, int n, int i) {
        int comp=0;
        int mov=0;
        int[]h;
        // Find largest among root, left child and right child
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        comp++;
        if (l < n && arr[l] > arr[largest])
            largest = l;

        comp++;
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // Swap and continue heapifying if root is not largest
        comp++;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            mov+=2;

            h=heapify(arr, n, largest);
            comp+=h[0];
            mov+=h[1];
        }
        return new int[]{comp,mov};
    }
    public static int[] gnomeSort(int[] arr, int n) {
        int index = 0;
        int comp=0;
        int mov=0;

        while (index < n) {
            if (index == 0) {
                comp++;
                index++;
            }
            if (arr[index] >= arr[index - 1]) {
                comp++;
                index++;
            }
            else {
                int temp = 0;
                temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                mov+=2;
                index--;
            }
        }
        return new int[]{comp,mov};
    }
}
