import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;


public class Fabrica_de_Poleras {
    static ArrayList<String> pedidos = new ArrayList<>();
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[]args){ menu(); }

    public static void menu (){
        boolean salir = false;
        int opcion;

        while (!salir){
            System.out.println("Seleccione una opción:\n 1: Crear un nuevo pedido\n 2: Eliminar un pedido \n 3:salir\n ");
            opcion = validarOpción();
            switch (opcion){
                case 1:
                    pedidoNuevo();
                    break;
                case 2:
                    eliminarPedido();
                    break;
                case 3:
                    salir=true;
                    break;
            }
        }
    }

    /**
     * Método que toma los datos del pedido se los entrega a un método crearPedido
     * una vez creado el pedido lo entrega al mètodo agregarALista
     */
    public static void pedidoNuevo(){
        String TIPO = leerTipo();
        String TALLA = leerTalla();
        String ESTAMPADO= leerEstampado();
        String nuevoPedido= crearPedido(TIPO,TALLA,ESTAMPADO);
        agregarALista(nuevoPedido);
    }

    /**
     * Método que concatena los 3 datos del pedido en un solo string
     * @param tipo es el tipo de tela
     * @param estampado es si o no la polera lleva estampado
     * @param talla la talla de la polera
     * @ return string que contiene los 3 datos del pedido
     */
    public static String crearPedido (String tipo, String talla, String estampado){
        return (tipo+","+talla+","+estampado);
    }

    /**
     * Método que agrega al Arraylist pedidos un nuevo string
     * @param nuevo es el nuevo pedido que se cró en crearPedido
     */
    public static void agregarALista(String nuevo){
        pedidos.add(nuevo);
    }

    /**
     * Método que si hay elementos en la lista llama al metodo que valida el numero de pedido a eliminar (i) y lo elimina
     * si la lista está vacía envía mensaje de error
     */
    public static void eliminarPedido(){
        if(pedidos.size()>0) {
            mostarPedidos();
            int i = validarIndice();
            pedidos.remove(i);
        }
        else{
            System.out.println("La lista de pedidos está vacía");
        }
    }

    /**
     * Método que muestra todos los elemntos del Arraylist Pedidos
     */
    public static void mostarPedidos(){
        for(int i=0; i<pedidos.size(); i++){
            System.out.println(i+1+": "+pedidos.get(i));
        }
    }

    /**
     * Método que revisa que el numéro de la opcion seleccionada sea válido
     * @return op valida seleccionada
     */
    public static int validarOpción(){
        int op;
        op=4;
        while (op<0 || op>3){
            op=leerNumero("una opción.");
            if (op<0 || op>3){
                System.out.println("Las opciones disponibles son 1, 2 y 3 ");
            }
        }
        return op;
    }

    /**
     * Método que revisa que el numéro de pedido que ingresa el usuariosea válido
     * @return i número de indice del pedido que se quiere eliminar
     */
    public static int validarIndice(){
        int i=-1;
        while(i<0){
            i = leerNumero("el número de pedido que desea eliminar")-1;
            if (i<0 || i>pedidos.size()){
                System.out.println("Error.el pedido que desea eliminar no existe. Pruebe denuevo con un número válido");
            }
        }
        return i;
    }

    /**
     * Método que revisa que regresa true si el usuario ingresa una talla  valida, y false si no lo es
     * @return estadoes verdadero cuando la talla corresponde a  S M L o XL
     */
    public static boolean validarTalla(String talla){
        boolean estado= false;
        if(talla.equals("S")||talla.equals("M")|| talla.equals("L")||talla.equals("XL")){
            estado=true;
        }
        return estado;
    }

    /**
     * Método que regresa un String con la talla válida cuando estado es true
     * @return talla es la talla de la polera
     */
    public static String leerTalla(){
        boolean estado = false;
        String talla= "";
        while(estado==false){
            System.out.println("ingrese la talla de la polera");
            talla= leerString();
            estado= validarTalla(talla);
            if (estado==false){ error(); }
        }
        return  talla;
    }

    /**
     * Método que revisa que regresa true si el usuario ingresa una tipo de tela es valida, y false si no lo es
     * @return estadoes verdadero cuando la talla corresponde a  spandex algodón o polyester
     */
    public static boolean validarTipo(String tela){
        boolean estado= false;
        if(tela.equals("spandex")||tela.equals("algodón")|| tela.equals("polyester")){
            estado=true;
        }
        return estado;
    }

    /**
     * Método que regresa un String con el tipo de tela válida cuando estado es true
     * @return tipo es el tipo de tela de la polera
     */
    public static String leerTipo(){
        boolean estado = false;
        String tipo= "";
        while(estado==false){
            System.out.println("ingrese el tipo de tela: spandex, algodón o polyester");
            tipo= leerString();
            estado= validarTipo(tipo);
            if (estado==false){ error(); }
        }
        return  tipo;
    }

    public static boolean validarEstampado(String talla){
        boolean estado= false;
        if(talla.equals("si")||talla.equals("no")){
            estado=true;
        }
        return estado;
    }

    /**
     * Método que regresa un String con si o no cuando estado es true
     * @return esmpado es si cuando la polera será estampada y no si no es espamada
     */
    public static String leerEstampado(){
        boolean estado = false;
        String estampado= "";
        while(estado==false){
            System.out.println("ingrese si, si es con estampado, y no, si la polera es sin estampado");
            estampado= leerString();
            estado= validarEstampado(estampado);
            if (estado==false){
                error();
            }
        }
        return  estampado;
    }

    /**
     * Método que  leer teclado un String
     * @return el String leido por teclado
     */
    public static String leerString (){ return teclado.nextLine(); }

    /**
     * Método que muestra un mensaje de error
     */
    public static void error(){
        System.out.println("Error!  Ingresa un valor correcto");
    }

    /**
     * Método que lee un int por teclado y si es otro tipo de dato lanza un error y lee denuevo
     */

    public static int leerNumero(String str){
        int num=0;
        System.out.println("ingrese "+ str);
        do{
            try{
                num=teclado.nextInt();
            }
            catch(InputMismatchException ime){
                error();
                teclado.next();
                num=-1;
            }
        }
        while(num<0);
        return num;
    }
}

