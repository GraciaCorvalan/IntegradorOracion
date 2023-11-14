
import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;

public class integradorOracion {
    public static void main(String[] args) {
        try{
        System.out.println("Hello, World!");
        Scanner lector = new Scanner(System.in);
        String oracion = "";
        int i=0;
        int longitud=0;
        int contador=0;
        int numero=0;
        boolean log=false;
        String palabra="";
        int rta;

        do{
        System.out.println("MENU \n 1.Crear o borrar oracion \n 2.contar la cantidad de caracteres \n 3.Contar la cantidad de palabras \n 4.Ordenar las palabras por orden alfabetico \n 5.Ingresar un numero para mostrar la palabra en esa posicion \n 6.Buscar la posicion de una palabra conocida \n 7.Modificar una palabra conocida de la oracion \n 8.Agregar contenido a la oracion \n 9.Mostrar oracion \n 10.Salir " );
        System.out.println("\n Elegir una opcion");
        rta = lector.nextInt();
        switch (rta){
            //crear o borrar
            case 1:
                if(oracion==""){
                    System.out.println("La oracion esta vacia. Escribir una oracion:");
                    lector.nextLine();
                    oracion=lector.nextLine();
                    System.out.println(" \n La oracion es: " + oracion);
                } else {
                    System.out.println(" \n Borrar oracion y escribir una nueva:");
                    lector.nextLine();
                    oracion=lector.nextLine();
                }
                break;
            //cant de caracteres
            case 2:
                if(oracion==""){
                    System.out.println("\n Oracion Vacia. Por favor CREE una oracion:");
                }else{
                    longitud=0;
                    for(i=0;i<oracion.length();i++){
                        if(Character.isLetterOrDigit(oracion.charAt(i))){
                            longitud = longitud +1;
                        }
                    }

                    System.out.println("\n La cantidad de caracteres es: " + longitud);
                    //System.out.println("\n La oracion es: " + oracion);
                }
                break;
            
            case 3:
            //cant de palabras
                if(oracion=="\n Oracion Vacia. Por favor ingrese una oracion"){
                }else{
                    contador=0;
                    for(i=0; i<oracion.length(); i++){
                        if (Character.isWhitespace(oracion.charAt(i))==true && Character.isLetterOrDigit(oracion.charAt(i+1)) ){
                            contador++;
                        }
                    }
                    System.out.println("\n Cantidad de palabras en la oracion: " + (contador+1));
                    //System.out.println("\n La oracion es: " + oracion);
                }
                break;
                
            case 4:
                // ordenar las palabras de la frase
                if(oracion==" \n Oracion Vacia. Por favor ingrese una oracion"){
                }else{
                    //primero cuento la cantidad de espacios para tener la cant de palabras, despues paso a array con split, despues ordeno
                    contador=0;
                    for(i=0; i<oracion.length(); i++){
                        if (Character.isWhitespace(oracion.charAt(i))==true){
                            contador++;
                        }
                    }
                    String[] oracionArr=new String[contador];
                    oracionArr=oracion.split(" ");
                    Arrays.sort(oracionArr);
                    System.out.println(Arrays.toString(oracionArr));
                    
                    //pasar el array a string
                    palabra="";
                    for (i=0;i<oracionArr.length;i++){
                        if(i==(oracionArr.length)-1){
                            palabra= palabra + oracionArr[i];
                        }else{
                            palabra= palabra + oracionArr[i] + " ";
                        }
                    }
                    System.out.println("\n La oracion es ordenada alfabeticamente es : "+palabra);
                }
                break;
                
            case 5:
            //ingresar un numero para mostrar la palabra
                if(oracion==""){
                    System.out.println("\n Oracion Vacia. Por favor ingrese una oracion");
                }else{
                    contador=0;
                    for(i=0; i<oracion.length(); i++){
                        if (Character.isWhitespace(oracion.charAt(i))==true){
                            contador++;
                        }
                    }
                    String[] oracionBuscar=new String[contador+1];
                    oracionBuscar=oracion.split(" ");
                    do{
                    System.out.println("\n Ingresar una ubicacion para buscar la palabra correspondiente. De 1 a "+(contador+1));
                    numero=lector.nextInt();
                    System.out.println("\n La palabra en esa posicion es: "+ oracionBuscar[numero-1]);
                    } while (numero>contador+1 || numero<0);
                }
                //System.out.println("\n La oracion es " + oracion);
                break;
            case 6:
                //Como saber si esta tal palabra, y si esta, en cual posicion
                if(oracion==""){
                    System.out.println("\n Oracion Vacia. Por favor ingrese una oracion");
                }else{
                    System.out.println("\n Ingresar una palabra. Si esta en la oracion, se dirá en cual posicion o posiciones");
                    palabra=lector.next();
                    //se crea el array con la palabra
                    for(i=0; i<oracion.length(); i++){
                        if (Character.isWhitespace(oracion.charAt(i))==true){
                            contador++;
                        }
                    }
                    String[] oracionBuscar=new String[contador+1];
                    oracionBuscar=oracion.split(" ");
                    //buscar la palabra
                    for(i=0; i<oracionBuscar.length; i++){
                        if(palabra.equals(oracionBuscar[i])){
                            System.out.println(" \n La palabra está en la posicion: " + (i+1));
                            log=true;
                        }
                    }
                    //
                    if(log==false){
                        System.out.println("\n La palabra no está en la oracion");
                    }
                }
                //System.out.println("\n La oracion es " + oracion);
                break;
            case 7:
            //modificar palabra, buscando la posicion por palabra
                if(oracion==""){
                    System.out.println("\n Oracion Vacia. Por favor ingrese una oracion");
                }else{
                    System.out.println(" \n Ingrese una palabra de la oracion para modificarla:");
                    palabra=lector.next();
                   
                    for(i=0; i<oracion.length(); i++){
                        if (Character.isWhitespace(oracion.charAt(i))==true){
                            contador++;
                        }
                    }
                    String[] oracionBuscar=new String[contador+1];
                    oracionBuscar=oracion.split(" ");

                    //
                    for(i=0; i<oracionBuscar.length; i++){
                        if(palabra.equals(oracionBuscar[i])){
                            log=true;
                            break;
                        }
                    }
                    //
                    if(log==true){
                    System.out.println("\n Modifique la palabra:");
                    oracionBuscar[i]=lector.next();
                    //pasar el array a string
                    oracion="";
                    for (i=0;i<oracionBuscar.length;i++){
                        if(i==(oracionBuscar.length)-1){
                            oracion= oracion + oracionBuscar[i];
                        }else{
                            oracion= oracion + oracionBuscar[i] + " ";
                        }
                    }
                    System.out.println("\n La oracion nueva es: "+oracion);
                    //
                    } else{
                        System.out.println("\n La palabra no esta en la oracion");
                    }
                }
                break;
            case 8:
            //Agregar contenido
                if(oracion==""){
                    System.out.println("\n Oracion Vacia. Por favor ingrese una oracion");
                }else{
                    System.out.println("\n Ingrese el contenido que desea agregar:");
                    //reutilizar el string palabra
                    lector.nextLine();
                    palabra=lector.nextLine();
                    oracion=oracion + " " + palabra;
                    System.out.println("\n La nueva oracion es : " + oracion);
                }
                break;
            case 9:
                System.out.println("\n La oracion es " + oracion);
                break;
            case 10:
                System.out.println("Salir");
                break;
        }
        } while (rta<10 && rta>0);
    lector.close();
        } catch (InputMismatchException e){
            System.out.println("\n Ingresar un numero, en vez de una letra.");
        }
    }
}
