
import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        
        Scanner teclado = new Scanner(System.in);
        int opcion;
        
        
        do{
            System.out.println("\n--- MENU DE PRODUCTOS ---");
            System.out.println("1. Ingresar productos");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Ordenar productos por precio");
            System.out.println("4. Buscar producto por nombre");
            System.out.println("5. Eliminar producto por ID");
            System.out.println("6.Salir");
            System.out.print("Seleccione una opcion: ");
            
             
            //Validar opción ingresada
          while(!teclado.hasNextInt()){
              System.out.println("Ingreso inválido. Debe ser un numero.");
              System.out.print("Seleccione una opcion: ");
              teclado.next();//Linea para limpiar la entrada
          }
          opcion = teclado.nextInt();
          teclado.nextLine();//Linea para limpiar buffer
          
          switch(opcion){
              case 1 -> Producto.ingresarProductos();
              case 2 -> Producto.imprimirProductos();
              case 3 -> Producto.ordenarPorPrecio();
              case 4 -> Producto.buscarPorNombre();
              case 5 -> Producto.eliminarProducto();
              case 6 -> System.out.println("\n--- Salindo del programa ---");
              default -> System.out.println("Opcion invalida. Intente nuevamente");
          }
          
        }while(opcion!=6); //El menu se repite mientras no se seleccione 6
        
        teclado.close(); //Cierre del scanner
        
        
        
        /*Crear objeto tipo producto
        Producto p = new Producto("Inicial,0.0,0");
        
        Llamamos a los metodos en orden

        Producto.ingresarProductos(); 
        Producto.ordenarPorPrecio(); 
        Producto.imprimirProductos(); 
        Producto.buscarPorNombre(); 
        Producto.eliminarProducto();
        
        Volvemos a llamar al metodo para que imprima nuevamemte
        luego de realizar la eliminación de un producto
        
        Producto.imprimirProductos();*/
        
    }
}

