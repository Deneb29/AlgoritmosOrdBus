package unidad1.tarea12;

import java.util.Scanner;

public class Aplicacion {
	public static void main(String[] args){
		Arbol a= new Arbol();
		String i,s;
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("Seleccione la opcion deseada:\n" +
					"1.- Llenar arbol\n" +
					"2.- Recorrido inOrder\n" +
					"3.- Recorrido preOrder\n" +
					"4.- Recorrido posOrder\n" +
					"5.- Recorrido inOrder codificado\n" +
					"6.- Recorrido preOrder codificado\n" +
					"7.- Recorrido posOrder codificado\n" +
					"8.- Buscar primera vocal\n" +
					"9.- Buscar palabras que inicien con consonante\n" +
					"0.- Salir");
			i = sc.nextLine();
			switch (i){
				case "1":
					String st;
					for(int j=0;j<5;j++){
						System.out.println("Ingrese un texto");
						st=sc.nextLine();
						a.crearArbolBinario(j,st);
					}
					break;
				case "2":
					a.entreOrden(a.raiz);
					break;
				case "3":
					a.preOrden(a.raiz);
					break;
				case "4":
					a.posOrden(a.raiz);
					break;
				case "5":
					a.entreOrdenCod(a.raiz);
					break;
				case "6":
					a.preOrdenCod(a.raiz);
					break;
				case "7":
					a.posOrdenCod(a.raiz);
					break;
				case "8":
					a.vocal(a.raiz);
					break;
				case "9":
					a.consonante(a.raiz);
					break;
			}
		}while (!i.equals("0"));
		}
}
