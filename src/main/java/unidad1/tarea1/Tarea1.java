package unidad1.tarea1;

import javax.swing.JOptionPane;

public class Tarea1 {
    public static void main(String[] args) {
        String s,t,i,u,v;
        int j,k,l;
        char a,b;
        s=t=u=v="";
        i=null;
        a=b=' ';
        do{
            i=JOptionPane.showInputDialog("Seleccione la opcion deseada:\n" +
                    "1.- equals\n" +
                    "2.- equalsIgnoreCase\n" +
                    "3.- compareTo\n" +
                    "4.- compareToIgnoreCase\n" +
                    "5.- endsWith\n" +
                    "6.- startsWith\n" +
                    "7.- indexOf\n" +
                    "8.- lastIndexOf\n" +
                    "9.- regionMatches\n" +
                    "10.- toLowerCase\n" +
                    "11.- toUpperCase\n" +
                    "12.- concat\n" +
                    "13.- trim\n" +
                    "14.- replace\n" +
                    "15.- substring\n" +
                    "16.- lenght\n" +
                    "17.- chatAt\n" +
                    "0.- Salir",null);

            switch (i){
                case "1":
                    s=guardarString("Ingrese primer texto");
                    t=guardarString("Ingrese otro texto");
                    if(s.equals(t)){
                        JOptionPane.showMessageDialog(null,s+" es igual a "+t);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,s+" es diferente de  "+t);
                    }
                    break;
                case "2":
                    s=guardarString("Ingrese primer texto");
                    t=guardarString("Ingrese otro texto");
                    if(s.equalsIgnoreCase(t)){
                        JOptionPane.showMessageDialog(null,s+" es igual a "+t);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,s+" es diferente de  "+t);
                    }
                    break;
                case "3":
                    s=guardarString("Ingrese primer texto");
                    t=guardarString("Ingrese otro texto");
                    j=s.compareTo(t);
                    if(j==0){
                        JOptionPane.showMessageDialog(null,s+" es igual a "+t);
                    }
                    else if(j<0){
                        JOptionPane.showMessageDialog(null,s+" es menor que "+t);
                    }
                    else if(j>0){
                        JOptionPane.showMessageDialog(null,s+" es mayor que "+t);
                    }
                    break;
                case "4":
                    s=guardarString("Ingrese primer texto");
                    t=guardarString("Ingrese otro texto");
                    j=s.compareToIgnoreCase(t);
                    if(j==0){
                        JOptionPane.showMessageDialog(null,s+" es igual a "+t);
                    }
                    else if(j<0){
                        JOptionPane.showMessageDialog(null,s+" es menor que "+t);
                    }
                    else if(j>0){
                        JOptionPane.showMessageDialog(null,s+" es mayor que "+t);
                    }
                    break;
                case "5":
                    s=guardarString("Ingrese primer texto");
                    t=guardarString("Ingrese otro texto");
                    if(s.endsWith(t)){
                        JOptionPane.showMessageDialog(null,s+" termina con "+t);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,s+" no termina con "+t);
                    }
                    break;
                case "6":
                    s=guardarString("Ingrese primer texto");
                    t=guardarString("Ingrese otro texto");
                    if(s.startsWith(t)){
                        JOptionPane.showMessageDialog(null,s+" comienza con "+t);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,s+" no comienza con "+t);
                    }
                    break;
                case "7":
                    s=guardarString("Ingrese primer texto");
                    t=guardarString("Ingrese otro texto");
                    j=s.indexOf(t);
                    if(j>=0){
                        JOptionPane.showMessageDialog(null,s+" contiene a "+t+" en el indice "+j+" por primera vez");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,s+" no contiene a "+t);
                    }
                    break;
                case "8":
                    s=guardarString("Ingrese primer texto");
                    t=guardarString("Ingrese otro texto");
                    j=s.lastIndexOf(t);
                    if(j>=0){
                        JOptionPane.showMessageDialog(null,s+" contiene a "+t+" en el indice "+j+" por ultima vez");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,s+" no contiene a "+t);
                    }
                    break;
                case "9":
                    s=guardarString("Ingrese el primer texto");
                    j=Integer.parseInt(guardarString("Ingrese la posicion desde donde empezar a buscar en el primer texto(numero)"));
                    t=guardarString("Ingrese el segundo texto");
                    k=Integer.parseInt(guardarString("Ingrese la posicion desde donde empezar a buscaren el segundo texto(numero)"));
                    l=Integer.parseInt(guardarString("Ingrese la cantidad de caracteres a buscar"));
                    if(s.regionMatches(true,j,t,k,l)){
                        JOptionPane.showMessageDialog(null,"La region buscada en el texto "+s+" fue encontrada en "+t);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"La region buscada en el texto "+s+" no fue encontrada en "+t);
                    }
                    break;
                case "10":
                    s=guardarString("Ingrese el texto");
                    JOptionPane.showMessageDialog(null,"El texto en minusculas es "+s.toLowerCase());
                    break;
                case "11":
                    s=guardarString("Ingrese el texto");
                    JOptionPane.showMessageDialog(null,"El texto en mayusculas es "+s.toUpperCase());
                    break;
                case "12":
                    s=guardarString("Ingrese el primer texto");
                    t=guardarString("Ingrese el segundo texto");
                    JOptionPane.showMessageDialog(null,"El texto concatenado es "+s.concat(t));
                    break;
                case "13":
                    s=guardarString("Ingrese el texto");
                    JOptionPane.showMessageDialog(null, s.trim());
                    break;
                case "14":
                    s=guardarString("Ingrese el texto");
                    a=guardarString("Ingrese el caracter a remplazar").charAt(0);
                    b=guardarString("Ingrese el caracter nuevo").charAt(0);
                    JOptionPane.showMessageDialog(null,"El texto modificado es "+s.replace(a,b));
                    break;
                case "15":
                    s=guardarString("Ingrese el texto");
                    j=Integer.parseInt(guardarString("Ingrese la posicion de inicio"));
                    k=Integer.parseInt(guardarString("Ingrese la posicion final"));
                    JOptionPane.showMessageDialog(null,"La region es "+s.substring(j,k));
                    break;
                case "16":
                    s=guardarString("Ingrese el texto");
                    JOptionPane.showMessageDialog(null,"El tamaño del texto es "+s.length());
                    break;
                case "17":
                    s=guardarString("Ingrese el texto");
                    j=Integer.parseInt(guardarString("Ingrese la posicion de deseada"));
                    JOptionPane.showMessageDialog(null,"El caracter en la posicion indicada es "+s.charAt(j));
                    break;
                default:
            }
        }while(!i.equals("0"));
    }
    public static String guardarString(String mensaje){
        return JOptionPane.showInputDialog(mensaje,null);
    }
}
