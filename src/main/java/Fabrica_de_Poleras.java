import java.util.Scanner;
import java.util.ArrayList;


public class Fabrica_de_Poleras {
    static ArrayList<String> pedidos = new ArrayList<>();
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[]args){
        pedidoNuevo();
    }

    public static void pedidoNuevo(){
        String tipo = validarTipo() ;
        String talla = validarTalla();
        String estampado = validarEstampado();
        String nuevoPedido= crearPedido(tipo, talla, estampado);
        agregarALista(nuevoPedido);
    }

    public static String crearPedido (String tipo, String talla, String estampado){
        return (tipo+","+talla+","+estampado);
    }

    public static void agregarALista(String nuevo){
        pedidos.add(nuevo);
    }

    public static String leerString (){
       return teclado.nextLine();
    }

    public static String validarTipo(){
        String tipo= " ";
        while (!tipo.equals("algodón") && !tipo.equals("polyester") && !tipo.equals("spandex")){
            System.out.println("ingrese el tipo de tela");
            tipo = leerString();
            if (!tipo.equals("algodón") && !tipo.equals("polyester") && !tipo.equals("spandex")){
                System.out.println("Cuidado! El tipo de material solo puede ser: algodón, polyester o spandex");
            }
        }
        return tipo;
    }

    public static String validarTalla(){
        String t= " ";
        while (!t.equals("S") && !t.equals("M") && !t.equals("L") && !t.equals("XL")){
            System.out.println("ingrese la talla: S, M, L o XL");
            t = leerString();
            if (!t.equals("S") && !t.equals("M") && !t.equals("L") && !t.equals("XL")){
                System.out.println("Cuidado! Solo hay tallas: S, M, L o XL");
            }
        }
        return t;
    }

    public static String validarEstampado(){
        String E= " ";
        while (!E.equals("si") && !E.equals("no") ){
            System.out.println("ingrese si, para polera estampada y no para polera sin estampar");
            E = leerString();
            if (!E.equals("si") && !E.equals("no")){
                System.out.println("Cuidado! Solo puedes ingresar si o no");
            }
        }
        return E;
    }

    public static void eliminarPedido(){
        int i =ingresarIndice();
        pedidos.remove(i);
    }

    public static int ingresarIndice(){

    }








}
