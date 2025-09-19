
//Importaciones de clases
import java.util.ArrayList; //Uso de listas dinamicas
import java.util.Scanner; //Uso de lectura de datos mediante teclado

public class Producto {

    //Atributos
    private int idProducto;
    private static int contador = 1;
    private String nombreProducto;
    private double precioProducto;
    private int cantidadProducto;

    //Creación de la lista estática para almacenar productos
    private static ArrayList<Producto> listaProductos = new ArrayList<>();
    private static Scanner teclado = new Scanner(System.in);

    //Constructores
    public Producto(/*int idProducto*/String nombre, double precio, int cantidad) {
        this.idProducto = contador++;
        this.nombreProducto = nombre;
        this.precioProducto = precio;
        this.cantidadProducto = cantidad;
    }

    //Getters y Setters
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    //----------------------------------------------------------------------------------------------------------
    //Metodos
    //Ingreso de N productos por teclado
    public static void ingresarProductos() {
        int centinela = -1; //Sirve para crear la variable y darle un valor inicial inválido garantizando que el bucle se ejecute

        //Pedir cuantos productos se van a ingresar
        do {
            try {
                System.out.print("¿Cuantos productos desea ingresar?: ");
                centinela = Integer.parseInt(teclado.nextLine());//Leer como String y convertir a Int
                if (centinela <= 0) {
                    System.out.println("Debe ingresar un número mayor a 0");
                    centinela = -1;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingreso inválido. Ingrese un número entero.");
            }
        } while (centinela <= 0);

        //Pedir los datos de cada producto
        for (int i = 0; i < centinela; i++) {
            System.out.println("\n--- Producto " + (i + 1) + " ---");
            String nombre;
            double precio = -1;
            int cantidad = -1;

            //Validar nombre
            do {
                System.out.print("Ingrese el nombre del producto: ");
                nombre = teclado.nextLine();
                if (nombre.isEmpty()) {
                    System.out.println("El nombre no puede estar vacío.");
                }
            } while (nombre.isEmpty());

            //Validar precio en Double
            do {
                try {
                    System.out.print("Ingrese el precio del producto: ");
                    precio = Double.parseDouble(teclado.nextLine());
                    //Validacion del precio
                    if (precio < 0) {
                        System.out.println("El precio debe ser mayor o igual a 0.");
                    }
                    //Manejo de error    
                } catch (NumberFormatException e) {
                    System.out.println("Ingreso inválido. Ingrese un número válido(ej: 10.5)");
                    precio = -1;//Forzar la repeticion del bucle
                }
            } while (precio < 0);

            //Validar cantidad en Int
            do {
                try {
                    System.out.print("Ingrese la cantidad del producto: ");
                    cantidad = Integer.parseInt(teclado.nextLine());
                    //Validacion de la cantidad
                    if (cantidad < 0) {
                        System.out.println("La cantidad debe ser mayor o igual a 0.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ingreso inválido. Ingrese un número entero.");
                    cantidad = -1;//Forzar la repeticion del bucle
                }
            } while (cantidad < 0);

            //Crear y agregar producto "ERROR"
            Producto p = new Producto(nombre, precio, cantidad);//Instancia del objeto y asignacion de parametros
            listaProductos.add(p);//Agregar producto a la lista
            System.out.println("Producto agregado con éxito.");
        }
    }

    //Metodo para imprimir todos los productos
    public static void imprimirProductos() {
        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            System.out.println("\n--- Lista de productos ---");
            for (Producto p : listaProductos) { //Recorre cada producto en la lista / p producto actual
                //printf permite dar formato
                System.out.printf("ID: %d | Nombre: %s | Precio: %.2f | Cantidad: %d%n", p.getIdProducto(), p.getNombreProducto(), p.getPrecioProducto(), p.getCantidadProducto());
            }
        }
    }

    //Metodo para ordenar los productos por precio usando el metodo de la burbuja
    public static void ordenarPorPrecio() {
        int centinela = listaProductos.size(); //obtener tamaño de la lista
        for (int i = 0; i < centinela - 1; i++) { //bucle externo para control de recorrido
            for (int j = 0; j < centinela - 1 - i; j++) { //bucle interno para comparar cada par de elementos
                //Inicio de comparacion e intercambio de posicion en la lista
                if (listaProductos.get(j).getPrecioProducto() > listaProductos.get(j + 1).getPrecioProducto()) {
                    Producto tempo = listaProductos.get(j);//Variable temporal tempo 
                    listaProductos.set(j, listaProductos.get(j + 1)); //Reemplazo del producto en la posicion j con otro producto
                    listaProductos.set(j + 1, tempo);
                }
            }
        }
        System.out.println("Productos ordenados por precio de menor a mayor.");
    }

    //Metodo para buscar por nombre
    public static void buscarPorNombre() {
        System.out.print("Ingrese el nombre del producto que busca: ");
        String nombreBuscado = teclado.nextLine().toLowerCase();
        boolean encontrado = false; //Variable de control

        for (Producto p : listaProductos) { //Recorre cada producto en la lista / p producto actual
            if (p.getNombreProducto().toLowerCase().equals(nombreBuscado)) {
                System.out.println("Producto encontrado: ");
                System.out.printf("ID: %d | Nombre: %s | Precio: %.2f | Cantidad: %d%n", p.getIdProducto(), p.getNombreProducto(), p.getPrecioProducto(), p.getCantidadProducto());
                encontrado = true; 
                break; //Cierre de bucle
            }
        }

        if (!encontrado) {
            System.out.println("No existe un producto con ese nombre");
        }
    }

    //Metodo para eliminar producto por ID
    public static void eliminarProducto() {
        int id = -1; //id almacenara el producto a eliminar
        boolean entradaValida = false; //Control de validez de dato ingresado

        //Validar que el ID sea un número entero
        do {
            try {
                System.out.print("Ingrese el ID del producto a eliminar: ");
                id = Integer.parseInt(teclado.nextLine());
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Ingreso inválido. Ingrese un número entero.");
            }
        } while (!entradaValida);

        boolean eliminado = false; //Control de eliminacion
        for (int i = 0; i < listaProductos.size(); i++) { //Recorre cada producto en la lista mediante i
            if (listaProductos.get(i).getIdProducto() == id) { //Compara cada ID de la lista con el ingresado
                listaProductos.remove(i); //Elimina producto de lista
                System.out.println("Producto eliminado correctamente.");
                eliminado = true;
                break;
            }
        }

        if (!eliminado) {
            System.out.println("No se encontró un producto con ese ID.");
        }
    }
}
