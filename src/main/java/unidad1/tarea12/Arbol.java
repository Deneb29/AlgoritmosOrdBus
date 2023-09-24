package unidad1.tarea12;

import java.util.StringTokenizer;

public class Arbol {
	Nodo raiz;
	public Arbol( ) {
		raiz= null; //apuntador al arbol binario
		}
	//Genera nuevo hijo izquierdo 
	public void hijoIzquierdo(Nodo p, int x, String texto) {
		Nodo q = new Nodo(x,texto); p.izquierdo= q;
		}
	//Genera nuevo hijo derecho
	public void hijoDerecho(Nodo p, int x,String texto) {
		Nodo q = new Nodo(x,texto);
		p.derecho= q;
		}
	//Retorna apuntador a raiz del arbol
	public Nodo getRaiz() {
		return raiz;
		}
	
	public void crearArbolBinario(int x,String texto) {
		Nodo p, q;
		if(raiz== null) {
			raiz= new Nodo(x,texto); //raiz del arbol binario
		}
		else{ //avanza a los niveles del arbol binario
			p = raiz;
			q = raiz;
			
			while(q != null) {
				p = q;
				if(x < p.info) {
					q = p.izquierdo; //avanza al hijo izquierdo
				}
				else {
					q = p.derecho; //avanza al hijo derecho
				}
			}
			
			if(x < p.info) {
				hijoIzquierdo(p, x,texto); //genera nuevo hijo izquierdo del nodo p
			}
			else {
				hijoDerecho(p, x,texto); //genera nuevo hijo derecho del nodo p
			}
		}
	}
	
	
	/* Recorrido en preorden*/
	public void preOrden(Nodo p) {
		if(p != null) {
			System.out.print(p.texto + "\t");
			preOrden(p.izquierdo);
			preOrden(p.derecho);
			}
	}
	
	/* Recorrido en entreorden*/
	public void entreOrden(Nodo p) {
		if(p != null) {
			entreOrden(p.izquierdo);
			System.out.print(p.texto + " \t");
			entreOrden(p.derecho);
		}
	}
	
	/* Recorrido en posorden*/
	public void posOrden(Nodo p) {
		if(p != null) {
			posOrden(p.izquierdo);
			posOrden(p.derecho);
			System.out.print(p.texto + "\t");
			}
	}
	/* Recorrido en preorden*/
	public void preOrdenCod(Nodo p) {
		if(p != null) {
			System.out.print(p.codificado+ "\t");
			preOrdenCod(p.izquierdo);
			preOrdenCod(p.derecho);
		}
	}

	/* Recorrido en entreorden*/
	public void entreOrdenCod(Nodo p) {
		if(p != null) {
			entreOrdenCod(p.izquierdo);
			System.out.print(p.codificado+ "\t");
			entreOrdenCod(p.derecho);
		}
	}

	/* Recorrido en posorden*/
	public void posOrdenCod(Nodo p) {
		if(p != null) {
			posOrdenCod(p.izquierdo);
			posOrdenCod(p.derecho);
			System.out.print(p.codificado+ "\t");
		}
	}
	public boolean estaVacio(){
		if(raiz==null){
			return true;
		}
		else {
			return false;
		}
	}
	public void encontrarPalabra(Nodo p, String s){
		if(p != null) {
			if(p.izquierdo!=null){
				encontrarPalabra(p.izquierdo,s);
			}
			if(p.texto.equals(s)){
				System.out.println(s);
			}
			if(p.derecho!=null){
				encontrarPalabra(p.derecho,s);
			}
		}
		else {
			System.out.println("Arbol vacio");
		}
	}
	public void vocal(Nodo p) {
		if(p != null) {
			vocal(p.izquierdo);
			for (int i=0;i<p.texto.length();i++){
				if (isVocal(p.texto.charAt(i))){
					System.out.print("La primera vocal encontrada en el string "+p.texto+" es "+p.texto.charAt(i)+" en el indice "+i+"\n");
					break;
				}
			}
			vocal(p.derecho);
		}
	}
	public void consonante(Nodo p) {
		if(p != null) {
			StringTokenizer st=new StringTokenizer(p.texto);
			String s="";
			consonante(p.izquierdo);
			System.out.println("Texto en el nodo: "+p.texto);
			System.out.println("Palabras que comienzan con consonante encontradas en el texto: ");
			while (st.hasMoreElements()) {
				s=st.nextToken();
				if (!isVocal(s.toCharArray()[0])) {
					System.out.println(s);
				}
			}
			consonante(p.derecho);
		}
	}
	public static boolean isVocal(char c) {
		return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'|| c == 'á'|| c == 'é'|| c == 'í'|| c == 'ó'|| c == 'ú'|| c == 'A'|| c == 'E'|| c == 'I'|| c == 'O'|| c == 'U'|| c == 'Á'|| c == 'É'|| c == 'Í'|| c == 'Ó'|| c == 'Ú');
	}
}

	
	

