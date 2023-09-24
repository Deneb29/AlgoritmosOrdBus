package unidad1.tarea12;

import javax.swing.*;

public class Nodo {
	int info;
	String texto, codificado;
	Nodo izquierdo, derecho;
	
	public Nodo (int dato, String texto) {
		info= dato;
		this.texto=texto;
		this.codificado=codificacionJV(texto);
		izquierdo = null;
		derecho = null;
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

	public static void decodificacionJV(String s){
		String codificado ="";
		codificado=codificacionJV(s);
		int l;
		String clave="JULIO";;
		String [] codarray= {"","","","",""};
		StringBuilder stb=new StringBuilder();//30241
		int n;
		String decodificado;
		l=codificado.length()%clave.length();
		int[]pos={2,5,3,1,4};

		StringBuilder recortado=new StringBuilder(codificado);
		char [] sobrantes=new char[l];
		if(l==1){
			sobrantes[0]= recortado.charAt(clave.length()*2);
			recortado.deleteCharAt(clave.length()*2);
		}
		if(l==2){
			recortado.deleteCharAt(clave.length()*2);
			sobrantes[0]= recortado.charAt(clave.length()*2);
			recortado.deleteCharAt(clave.length()*5);
			sobrantes[1]= recortado.charAt(clave.length()*5);
		}
		if (l==3){
			recortado.deleteCharAt(clave.length()*2);
			sobrantes[0]= recortado.charAt(clave.length()*2);
			recortado.deleteCharAt(clave.length()*5);
			sobrantes[1]= recortado.charAt(clave.length()*5);
			recortado.deleteCharAt(clave.length()*3);
			sobrantes[2]= recortado.charAt(clave.length()*3);
		}
		if(l==4){
			recortado.deleteCharAt(clave.length()*2);
			sobrantes[0]= recortado.charAt(clave.length()*2);
			recortado.deleteCharAt(clave.length()*5);
			sobrantes[1]= recortado.charAt(clave.length()*5);
			recortado.deleteCharAt(clave.length()*3);
			sobrantes[2]= recortado.charAt(clave.length()*3);
			recortado.deleteCharAt(clave.length());
			sobrantes[3]= recortado.charAt(clave.length());
		}
		codificado=recortado.toString();
		codarray = codificado.split("(?<=\\G.{" + clave.length() + "})");

		if (codarray.length==1){
			for (int m=0;m<codarray[0].length();m++){
				for (n=0;n< codarray.length;n++) {
					int o=pos[m]-1;
					stb.append(codarray[n].charAt(o));
				}
			}
		}
		else {
			for (int m=0;m<codarray[0].length();m++){
				for (n=0;n< codarray.length;n++) {
					int o=pos[n]-1;
					stb.append(codarray[o].charAt(m));
				}
			}
		}


		if(l==1){
			stb.insert(clave.length()*5,sobrantes[0]);
		}
		if(l==2){
			stb.insert(clave.length()*5,sobrantes[0]);
			stb.insert(clave.length()*4,sobrantes[1]);
		}
		if (l==3){
			stb.insert(clave.length()*5,sobrantes[0]);
			stb.insert(clave.length()*4,sobrantes[1]);
			stb.insert(clave.length()*3,sobrantes[2]);
		}
		if(l==4){
			stb.insert(clave.length()*5,sobrantes[0]);
			stb.insert(clave.length()*4,sobrantes[1]);
			stb.insert(clave.length()*3,sobrantes[2]);
			stb.insert(clave.length()*2,sobrantes[3]);
		}

		decodificado=stb.toString();
		decodificado=decodificado.replace('%',' ');
		JOptionPane.showMessageDialog(null, "El string decodificado es "+decodificado);
	}

}
