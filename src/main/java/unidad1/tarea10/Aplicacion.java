package unidad1.tarea10;

import java.util.Scanner;

public class Aplicacion {
	public static void main(String[] args){
		Arbol a= new Arbol();
		String i,s,t;
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("Seleccione la opcion deseada:\n" +
					"1.- Llenar arbol\n" +
					"2.- Contar letras\n" +
					"3.- Reemplazar texto\n" +
					"4.- Recorrido inOrder\n" +
					"5.- Recorrido preOrder\n" +
					"6.- Recorrido posOrder\n" +
					"7.- Cantidad de nodos\n" +
					"8.- Profundidad del arbol\n" +
					"9.- Borrar nodo\n" +
					"10.- Buscar parrafo\n" +
					"11.- Convertir a mayusculas\n" +
					"12.- Convertir a minusculas\n" +
					"0.- Salir");
			i = sc.nextLine();
			switch (i){
				case "1":
					System.out.println("Ingrese un texto");
					s=sc.nextLine();
					a.insertarNodo(s);
					break;
				case "2":
					a.contarLetras(a.raiz);
					break;
				case "3":
					System.out.println("Ingrese el texto a reemplazar");
					s=sc.nextLine();
					System.out.println("Ingrese el texto nuevo");
					t=sc.nextLine();
					a.cambiarParrafo(s,t,a.raiz);
					break;
				case "4":
					a.entreOrden(a.raiz);
					break;
				case "5":
					a.preOrden(a.raiz);
					break;
				case "6":
					a.posOrden(a.raiz);
					break;
				case "7":
					System.out.println("Cantidad de nodos: "+ a.contarNodos(a.raiz));
					break;
				case "8":
					System.out.println("Profundidad del arbol: "+ a.profundidad(a.raiz));
					break;
				case "9":
					System.out.println("Ingrese numero de nodo a borrar");
					s=sc.nextLine();
					a.eliminar(a.raiz,s);
					break;
				case "10":
					System.out.println("Ingrese el parrafo a buscar");
					s=sc.nextLine();
					a.encontrarPalabra(a.raiz,s);
					break;
				case "11":
					a.aMayusculas(a.raiz);
					System.out.println("Parrafos convertidos a mayuscula");
				break;
				case "12":
					a.aMinusculas(a.raiz);
					System.out.println("Parrafos convertidos a minuscula");
					break;
				case "13":
					System.out.println("Frase: ");
					a.frase(a.raiz,"");
					System.out.println();
					break;
			}
		}while (!i.equals("0"));
		}
}
