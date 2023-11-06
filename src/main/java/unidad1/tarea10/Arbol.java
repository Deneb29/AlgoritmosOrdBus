package unidad1.tarea10;

import java.util.StringTokenizer;

public class Arbol {
	Nodo raiz;
	public Arbol( ) {
		raiz= null; //apuntador al arbol binario
		}

	public void insertarNodo(String nom){
		Nodo nuevo = new Nodo(nom);
		if (raiz == null){
			raiz = nuevo;
		}else{
			Nodo auxiliar = raiz;
			Nodo padre;
			while(true){
				padre=auxiliar;
				if (nom.compareToIgnoreCase(auxiliar.texto)<0){
					auxiliar=auxiliar.izquierdo;
					if (auxiliar==null){
						padre.izquierdo=nuevo;
						return;
					}
				}else{
					auxiliar=auxiliar.derecho;
					if(auxiliar==null){
						padre.derecho=nuevo;
						return;
					}
				}
			}
		}
	}//




	/* Recorrido en preorden*/
	public void preOrden(Nodo p) {
		if(p != null) {
			System.out.println(p.texto);
			preOrden(p.izquierdo);
			preOrden(p.derecho);
			}
	}
	
	/* Recorrido en entreorden*/
	public void entreOrden(Nodo p) {
		if(p != null) {
			entreOrden(p.izquierdo);
			System.out.println(p.texto);
			entreOrden(p.derecho);
		}
	}
	
	/* Recorrido en posorden*/
	public void posOrden(Nodo p) {
		if(p != null) {
			posOrden(p.izquierdo);
			posOrden(p.derecho);
			System.out.println(p.texto);
			}
	}
	/* Recorrido en preorden*/
	public void preOrdenCod(Nodo p) {
		if(p != null) {
			System.out.println(p.codificado);
			preOrdenCod(p.izquierdo);
			preOrdenCod(p.derecho);
		}
	}

	/* Recorrido en entreorden*/
	public void entreOrdenCod(Nodo p) {
		if(p != null) {
			entreOrdenCod(p.izquierdo);
			System.out.println(p.codificado);
			entreOrdenCod(p.derecho);
		}
	}

	/* Recorrido en posorden*/
	public void posOrdenCod(Nodo p) {
		if(p != null) {
			posOrdenCod(p.izquierdo);
			posOrdenCod(p.derecho);
			System.out.println(p.codificado);
		}
	}
	public void encontrarPalabra(Nodo p, String s){
		if(p != null) {
			if(p.izquierdo!=null){
				encontrarPalabra(p.izquierdo,s);
			}
			if(p.texto.equals(s)){
				System.out.println("Se ha encontrado la palabra "+s);
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
	public void contarLetras(Nodo p) {
		int letras,vocales,consoantes,digitos,espacios,caracteres,palabras,letrast,vocalest,consoantest,digitost,espaciost,caracterest;
		letras=vocales=consoantes=digitos=espacios=caracteres=palabras=letrast=vocalest=consoantest=digitost=espaciost=caracterest=0;
		if(p != null) {
			StringTokenizer st=new StringTokenizer(p.texto);
			String s="";
			contarLetras(p.izquierdo);
			letrast+=getLetras(p.texto);
			vocalest+=getVocales(p.texto);
			consoantest+=getConsonantes(p.texto);
			digitost+=getDigitos(p.texto);
			espaciost+=getEspacios(p.texto);
			caracterest+=getCaracteres(p.texto);
			palabras=getPalabras(p.texto);
			System.out.println("Texto en el nodo: "+p.texto);
			System.out.println("Palabras encontradas en el texto:");
			while (st.hasMoreElements()) {
				s=st.nextToken();
				System.out.println(s);
				letras=getLetras(s);
				vocales=getVocales(s);
				consoantes=getConsonantes(s);
				digitos=getDigitos(s);
				espacios=getEspacios(s);
				caracteres=getCaracteres(s);
				System.out.println("Letras: "+letras);
				System.out.println("Vocales: "+vocales);
				System.out.println("Consonantes: "+consoantes);
				System.out.println("Digitos: "+digitos);
				System.out.println("Espacios: "+espacios);
				System.out.println("Caracteres: "+caracteres);
			}
			System.out.println("Palabras totales: "+palabras);
			System.out.println("Letras totales: "+letrast);
			System.out.println("Vocales totales: "+vocalest);
			System.out.println("Consonantes totales: "+consoantest);
			System.out.println("Digitos totales: "+digitost);
			System.out.println("Espacios totales: "+espaciost);
			System.out.println("Caracteres totales: "+caracterest);
			contarLetras(p.derecho);
		}
	}
	public void cambiarParrafo(String actual, String nuevo, Nodo p){
		if(p != null) {
			if(p.izquierdo!=null){
				encontrarPalabra(p.izquierdo,actual);
			}
			if(p.texto.equals(actual)){
				p.texto=nuevo;
				p.codificado=codificacionJV(nuevo);
			}
			if(p.derecho!=null){
				encontrarPalabra(p.derecho,actual);
			}
		}
		else {
			System.out.println("Arbol vacio");
		}
	}
	public int contarNodos(Nodo p) {
		int nodos=0;
		if(raiz==null) {
			return 0;
		}
		else{
			int izq=0;
			int der=0;
			if(p.izquierdo!=null){
				izq=contarNodos(p.izquierdo);
			}
			if(p.derecho!=null){
				der=contarNodos(p.derecho);
			}
			return 1 + izq + der;
		}
	}
	public int profundidad(Nodo p) {
		if(p == null){
			return 0;
		}

		int altizq = profundidad(p.izquierdo);
		int altder = profundidad(p.derecho);

		return 1 + Math.max(altizq, altder);
	}
	public Nodo eliminar(Nodo nodo, String busqueda) {
		if (nodo == null) {
			return nodo;
		}
		if (busqueda.compareToIgnoreCase(nodo.texto)>0) {
			nodo.derecho=this.eliminar(nodo.derecho, busqueda);
		} else if (busqueda.compareToIgnoreCase(nodo.texto)<0) {
			nodo.izquierdo=this.eliminar(nodo.izquierdo, busqueda);
		} else {
			if (nodo.izquierdo == null && nodo.derecho == null) {
				nodo = null;
			} else if (nodo.derecho != null) {
				nodo.texto=this.sucesor(nodo);
				nodo.derecho=this.eliminar(nodo.derecho, nodo.texto);
			} else {
				nodo.texto=this.predecesor(nodo);
				nodo.izquierdo=this.eliminar(nodo.izquierdo, nodo.texto);
			}
		}
		return nodo;
	}

	private String sucesor(Nodo nodo) {
		nodo = nodo.derecho;
		while (nodo.izquierdo != null) {
			nodo = nodo.izquierdo;
		}
		return nodo.texto;
	}

	private String predecesor(Nodo nodo) {
		nodo = nodo.izquierdo;
		while (nodo.derecho != null) {
			nodo = nodo.derecho;
		}
		return nodo.texto;
	}
	public void aMayusculas(Nodo p){
		if(p != null) {
			aMayusculas(p.izquierdo);
			p.texto=p.texto.toUpperCase();
			p.codificado=codificacionJV(p.texto);
			aMayusculas(p.derecho);
		}
	}
	public void aMinusculas(Nodo p){
		if(p != null) {
			aMinusculas(p.izquierdo);
			p.texto=p.texto.toLowerCase();
			p.codificado=codificacionJV(p.texto);
			aMinusculas(p.derecho);
		}
	}
	public String cuartaPalabra(Nodo p){
		String res = "";
		if(p!=null) {
			String[] arr = p.texto.split(" ");
			for (int i = 0; i < arr.length; i++) {
				if (i == 3) {
					res = arr[i];
				}
			}
		}
		return res;
	}
	public void frase(Nodo p, String res){
		if(p != null) {
			frase(p.izquierdo,res);
			frase(p.derecho,res);
			if(p.derecho!=null && p.izquierdo!=null){
				res+=cuartaPalabra(p);
				System.out.print(res);
			}
			if(p.derecho==null && p.izquierdo==null){
				res+=cuartaPalabra(p);
				System.out.print(res);
			}
		}
	}
	public static boolean isVocal(char c) {
		return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'|| c == 'á'|| c == 'é'|| c == 'í'|| c == 'ó'|| c == 'ú'|| c == 'A'|| c == 'E'|| c == 'I'|| c == 'O'|| c == 'U'|| c == 'Á'|| c == 'É'|| c == 'Í'|| c == 'Ó'|| c == 'Ú');
	}
	public static int getLetras(String s){
		int letras;
		char[] array;
		array=s.toCharArray();
		letras=0;
		for (char c:
				array) {
			if(Character.isAlphabetic(c)) {
				letras++;
			}
		}
		return letras;
	}
	public static int getVocales(String s){
		int vocales;
		char[] array;
		array=s.toCharArray();
		vocales=0;
		for (char c:
				array) {
			if(Character.isAlphabetic(c) && isVocal(c)) {
				vocales++;
			}
		}
		return vocales;
	}
	public static int getConsonantes(String s){
		int cons;
		char[] array;
		array=s.toCharArray();
		cons=0;
		for (char c:
				array) {
			if(Character.isAlphabetic(c) && !isVocal(c)) {
				cons++;
			}
		}
		return cons;
	}
	public static int getDigitos(String s){
		char[] array;
		int digitos;
		array=s.toCharArray();
		digitos=0;

		for (char c:
				array) {
			if(Character.isDigit(c)){
				digitos++;
			}
		}
		return digitos;
	}
	public static int getEspacios(String s){
		char[] array;
		int espacios;
		array=s.toCharArray();
		espacios=0;
		for (char c:
				array) {
			if(Character.isWhitespace(c)){
				espacios++;
			}
		}
		return espacios;
	}
	public static int getCaracteres(String s){
		char[] array;
		int caracteres;
		array=s.toCharArray();
		caracteres=0;
		for (char c:
				array) {
			if(!Character.isLetterOrDigit(c)&&!Character.isWhitespace(c)){
				caracteres++;
			}
		}
		return caracteres;
	}
	public static int getPalabras(String s){
		StringTokenizer tokens;
		tokens=new StringTokenizer(s," ");
		return tokens.countTokens();
	}
	public static String codificacionJV(String s){
		String codificado = s.replace(' ', '%');
		String codificado2="";
		String [] codarray={"","","","",""};
		String clave="JULIO";
		int[]pos={2,5,3,1,4};
		char lts[][] =new char[20][clave.length()];
		int l=0;
		for (int j=0;j<20;j++) {
			for(int k=0;k<clave.length();k++){
				if(l< codificado.length()) {
					lts[j][k] = codificado.charAt(l);
				}
				l++;
			}
		}
		for(int col=0;col<clave.length();col++) {
			int m=pos[col]-1;
			for (int fila = 0; fila < 20; fila++) {
				if(lts[fila][col] != 0){
					codarray[m]+=lts[fila][col];
				}
			}
		}
		for (String st:
				codarray) {
			codificado2+=st;
		}
		return codificado2;
	}
}

	
	

